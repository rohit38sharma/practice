package com.rohit.practice.leetcode.LinkedList;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class LT19RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s,e;
        s = e = head;
        int i = 0;
        while(e.next!=null && i<n){
            e = e.next;
            ++i;
        }
        if(i<n){
            return head.next;
        }
        while(e.next!=null){
            e = e.next;
            s = s.next;
        }

        if(s.next!=null){
            s.next = s.next.next;
        }
        return head;
    }
}
