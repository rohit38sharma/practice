package com.rohit.practice.leetcode.String;

import java.util.*;

public class AggregateCount {
    public static List<String> subdomainVisits(String[] cpdomains) {
        int n = cpdomains.length;
        HashMap<String, Integer> domainCount = new HashMap<>();

        for(String cpdomain : cpdomains){
            String[] cpdomainsplit = cpdomain.split(" ");
            if(cpdomainsplit.length < 2)
                continue;
            int count = Integer.parseInt(cpdomainsplit[0]);
            domainCount.put(cpdomainsplit[1], domainCount.getOrDefault(cpdomainsplit[1], 0) + count);
            String[] domains = cpdomainsplit[1].split("\\.");

            for(int i=1;i<domains.length;++i){
                String subDomain = findSubDomain(".", domains, i);
                domainCount.put(subDomain, domainCount.getOrDefault(subDomain, 0) + count);
            }
        }

        List<String> subdomainCounts = new ArrayList<>();

        for(String domain : domainCount.keySet()){
            StringBuilder sb = new StringBuilder();
            sb.append(domainCount.get(domain));
            sb.append(" ");
            sb.append(domain);
            subdomainCounts.add(sb.toString());
        }

        return subdomainCounts;
    }

    private static String findSubDomain(String del, String[] domains, int idx){
        int n = domains.length;
        StringBuilder sb = new StringBuilder();
        for(int i=idx;i<n;++i){
            if(i>idx)
                sb.append(del);
            sb.append(domains[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] input = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        List<String> result = subdomainVisits(input);
        for (String entry : result) {
            System.out.println(entry);
        }
    }
}
