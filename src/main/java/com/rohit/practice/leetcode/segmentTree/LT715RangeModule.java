package com.rohit.practice.leetcode.segmentTree;

import java.util.ArrayList;
import java.util.List;

public class LT715RangeModule {
    private class Segment{
        int s;
        int e;
        boolean isTracked;

        Segment left, right;

        public Segment(int s, int e){
            this.s = s;
            this.e = e;
        }

        public Segment(int s, int e, boolean isTracked){
            this.s = s;
            this.e = e;
            this.isTracked = isTracked;
        }
    }

    private boolean updateSegment(Segment root, int left, int right, boolean isTracked){
        if(right <= root.s || left >= root.e){
            return root.isTracked;
        }

        if(left <= root.s && right >= root.e){
            root.isTracked = isTracked;
            root.left = null;
            root.right = null;
            return isTracked;
        }

        int mid = root.s + (root.e - root.s)/2;

        if(root.left == null){
            root.left = new Segment(root.s, mid, root.isTracked);
            root.right = new Segment(mid, root.e, root.isTracked);
        }

        boolean leftRes = updateSegment(root.left, left, right, isTracked);
        boolean rightRes = updateSegment(root.right, left, right, isTracked);

        root.isTracked = leftRes && rightRes;

        return root.isTracked;
    }

    private boolean querySegment(Segment root, int left, int right){
        if(left <= root.s && right >= root.e){
            return root.isTracked;
        }

        if(right <= root.s || left >= root.e){
            return true;
        }

        boolean leftRes = root.left==null ?root.isTracked :querySegment(root.left, left, right);
        boolean rightRes = root.right==null ?root.isTracked :querySegment(root.right, left, right);

        return leftRes && rightRes;
    }

    private Segment root;
    public LT715RangeModule() {
        root = new Segment(0, 1000000000);
    }

    public void addRange(int left, int right) {
        updateSegment(root, left, right, true);
    }

    public boolean queryRange(int left, int right) {
        return querySegment(root, left, right);
    }

    public void removeRange(int left, int right) {
        updateSegment(root, left, right, false);
    }
}
