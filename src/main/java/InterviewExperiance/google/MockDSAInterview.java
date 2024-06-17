package InterviewExperiance.google;

/**
 * Given a Binary Search Tree and two values representing the start and end of a range, return the sum of all nodes within that range.
 *
 *             10
 *             8		  15
 *             5		9  12	  20
 *
 *     Start = 7
 *     End = 17
 *
 *     Sum = 10 + 8 + 9 + 15 + 12 = 54
 *
 *
 *     N - nodes
 *     O(N)Time
 *     O(N)space
 *
 * 10
 *         8		  15
 *         5		9  12	  20
 *
 *     Start = 7
 *     End = 17
 *
 *     Sum = 10 + 8 + 9 + 15 + 12 = 54
 *
 *     Node = 10 -> 8 -> 5 -> N -> 5 -> 8 -> 9 -> N -> 9 -> N -> 9 -> 8 -> 10 -> 15 -> 12 -> N -> 12 -> N -> 12 -> 15 -> 20 -> N -> 20 -> 15 -> 10 -> Main call
 */

public class MockDSAInterview {
    private class BST{
        int num;
        BST left;
        BST right;
    }

    private int sum = 0;
    public int RangeSum(BST root, int start, int end){
        rangeSumRec(root, start, end);
        return sum;
    }

    private void rangeSumRec(BST node, int start, int end){
        if(node == null)
            return;

        if(node.num >= start && node.num <= end){
            sum += node.num;
        }

        if(node.num >= start){
            rangeSumRec(node.left, start, end);
        }

        if(node.num <= end){
            rangeSumRec(node.right, start, end);
        }
    }
}
