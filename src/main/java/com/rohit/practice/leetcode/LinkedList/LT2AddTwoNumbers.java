package com.rohit.practice.leetcode.LinkedList;

//https://leetcode.com/problems/add-two-numbers/
public class LT2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode prev = sum;
        int carry = 0;
        while(l1!=null || l2!=null || carry>0){
            if(l1!=null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                carry += l2.val;
                l2 = l2.next;
            }

            ListNode cur = new ListNode(carry%10);
            prev.next = cur;
            prev = cur;

            carry /= 10;
        }

        return sum.next;
    }
}
