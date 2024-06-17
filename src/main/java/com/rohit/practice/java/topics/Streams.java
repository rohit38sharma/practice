package com.rohit.practice.java.topics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Streams{
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,4,10,6,8,12);
        Map<Integer,Integer> map1 = new HashMap<>();
        boolean res = list.stream().map(a -> a%2).allMatch(a -> a==0);
        System.out.println(res);

        list.forEach(System.out::println);
    }
}
