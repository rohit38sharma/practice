package com.rohit.practice.leetcode.tree;

import java.util.*;

public class LT236LCABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //Iterative Approach with parent pointer
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode cur = st.pop();
            if(cur.left != null){
                parent.put(cur.left, cur);
                st.push(cur.left);
            }
            if(cur.right != null){
                parent.put(cur.right, cur);
                st.push(cur.right);
            }
        }

        Set<TreeNode> ancestors_p = new HashSet<>();

        while(p != null){
            ancestors_p.add(p);
            p = parent.get(p);
        }

        while(!ancestors_p.contains(q)){
            q = parent.get(q);
        }

        return q;
    }

    //Recursive approach
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        findLca(root, p, q);

        return lca;
    }

    private boolean findLca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return false;

        boolean left = findLca(root.left, p, q);

        boolean mid = false;
        if(root == p || root == q){
            mid = true;
        }

        boolean right = findLca(root.right, p, q);

        if(left && mid || left && right || mid && right){
            lca = root;
        }

        return left || mid || right;
    }
}
