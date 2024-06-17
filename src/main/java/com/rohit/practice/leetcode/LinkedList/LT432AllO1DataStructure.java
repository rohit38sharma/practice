package com.rohit.practice.leetcode.LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LT432AllO1DataStructure {
    private class ListNode{
        int freq;
        ListNode prev;
        ListNode next;

        Set<String> keys;

        public ListNode(int freq){
            this.freq = freq;
            this.keys = new HashSet<>();
        }
    }

    private void addNodeAfter(ListNode cur, ListNode node){
        ListNode next = cur.next;

        cur.next = node;
        next.prev = node;

        node.prev = cur;
        node.next = next;
    }

    private void removeNode(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;

        prev.next = next;
        next.prev = prev;

        node.prev = null;
        node.next = null;
    }

    private void removeKeyFromNode(ListNode node, String key){
        node.keys.remove(key);

        if(node != head && node.keys.isEmpty()){
            removeNode(node);
        }
    }

    private ListNode head;
    private ListNode tail;
    private Map<String, ListNode> keyNodeMap;

    public LT432AllO1DataStructure() {
        keyNodeMap = new HashMap<>();

        head = new ListNode(0);
        tail = new ListNode(Integer.MAX_VALUE);

        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if(!keyNodeMap.containsKey(key)){
            head.keys.add(key);
            keyNodeMap.put(key, head);
        }

        ListNode curNode = keyNodeMap.get(key);
        int curFreq = curNode.freq;
        int newFreq = curFreq + 1;

        if(curNode.next.freq != newFreq){
            ListNode node = new ListNode(newFreq);
            addNodeAfter(curNode, node);
        }

        ListNode newNode = curNode.next;
        newNode.keys.add(key);
        keyNodeMap.put(key, newNode);

        removeKeyFromNode(curNode, key);
    }

    public void dec(String key) {
        ListNode curNode = keyNodeMap.get(key);
        int curFreq = curNode.freq;
        int newFreq = curFreq - 1;

        if(curNode.prev.freq != newFreq){
            ListNode node = new ListNode(newFreq);
            addNodeAfter(curNode.prev, node);
        }

        if(newFreq <= 0){
            keyNodeMap.remove(key);
        }else{
            ListNode newNode = curNode.prev;
            newNode.keys.add(key);
            keyNodeMap.put(key, newNode);
        }

        removeKeyFromNode(curNode, key);
    }

    public String getMaxKey() {
        if(keyNodeMap.isEmpty()){
            return "";
        }

        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if(keyNodeMap.isEmpty()){
            return "";
        }

        return head.next.keys.iterator().next();
    }
}
