package com.rohit.practice.leetcode.LinkedList;

import java.util.Stack;
//https://leetcode.com/problems/reorder-list/
public class LT143ReorderList {
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        Stack<ListNode> st = new Stack<>();
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        ListNode cur = mid.next;
        mid.next = null;

        ListNode head2=null;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = head2;
            head2 = cur;
            cur = temp;
        }

        ListNode left = head, right = head2;
        while(left!=null && right!=null){
            ListNode tempL = left.next;
            ListNode tempR = right.next;
            left.next = right;
            right.next = tempL;
            left = tempL;
            right = tempR;
        }

    }
}
