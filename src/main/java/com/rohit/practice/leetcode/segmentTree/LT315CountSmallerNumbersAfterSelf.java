package com.rohit.practice.leetcode.segmentTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LT315CountSmallerNumbersAfterSelf {
    private class Segment{
        int l,r;
        int count;
        Segment left, right;

        public Segment(int l, int r){
            this.l = l;
            this.r = r;
            this.count = 0;
        }

        public int mid() {
            return ((r + 1 - l) / 2 + l);
        }
    }

    private void update(int num, Segment root){
        if(root.l > num || root.r < num){
            return;
        }

        root.count += 1;

        if(root.l == root.r){
            return;
        }

        int mid = root.mid();

        if(num < mid){
            if(root.left == null){
                root.left = new Segment(root.l, mid - 1);
            }
            update(num, root.left);
        }else{
            if(root.right == null){
                root.right = new Segment(mid, root.r);
            }
            update(num, root.right);
        }
    }

    private int query(int num, Segment root){
        if (root == null){
            return 0;
        }

        if(num >= root.r){
            return root.count;
        }

        int mid = root.mid();

        if(num < mid){
            return query(num, root.left);
        }else{
            return query(num, root.left) + query(num, root.right);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Segment root = new Segment(-10000, 10000);

        List<Integer> smallerCount = new ArrayList<>();
        for(int i=n-1;i>=0;--i){
            int count = query(nums[i] - 1, root);
            smallerCount.add(count);
            update(nums[i], root);
        }

        Collections.reverse(smallerCount);

        return smallerCount;
    }
}
