package com.rohit.practice.leetcode;

import java.util.*;

public class VisaScreeningQ1 {
    public static String[] numberOfEvents(String[] members, String[][] events){
        int m = members.length;

        Map<String, Integer> count = new HashMap<>();
        Map<String, Integer> active = new HashMap<>();
        for(int i=0;i<m;++i){
            count.put(members[i],0);
            active.put(members[i],0);
        }
        int e = events.length;
        int allCount = 0;
        for(int i=0;i<e;++i){
            String[] event = events[i];
            int time = Integer.parseInt(event[1]);
            if(event[0].equalsIgnoreCase("MESSAGE")){
                String[] to =  event[2].split(" ");
                HashSet<String> users = new HashSet<>();
                for(int j=0;j<to.length;++j){
                    if(to[j].equalsIgnoreCase("ALL")){
                        ++allCount;
                        users = new HashSet<>();
                        break;
                    }else if(to[j].equalsIgnoreCase("HERE")){
                        for(String u : active.keySet()){
                            if(active.get(u) <= time){
                                users.add(u);
                            }
                        }
                    }else{
                        users.add(to[j]);
                    }
                }
                for(String u : users){
                    count.put(u, count.get(u)+1);
                }
            }else if(event[0].equalsIgnoreCase("OFFLINE")){
                active.put(event[2], time + 60);
            }
        }

        String[] res = new String[m];
        int k=0;
        for(String u : count.keySet()){
            count.put(u, count.get(u)+allCount);
            res[k++] = u + "=" +count.get(u);
        }
        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args) {
        String[] members = {"id42","id158","id23"};
        String[][] events = {{"MESSAGE","0","ALL id158 id42"},
                {"OFFLINE","1","id158"},
                {"MESSAGE","2","id158 id158"},
                {"OFFLINE","3","id23"},
                {"MESSAGE","60","HERE id158 id42 id23"},
                {"MESSAGE","61","HERE"}};

        String[] ans = numberOfEvents(members, events);
        for(int i=0;i<ans.length;++i){
            System.out.println(ans[i]);
        }
    }
}
