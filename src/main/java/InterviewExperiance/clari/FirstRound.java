package InterviewExperiance.clari;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 Count Unique BSTs with N number of nodes
 0 <= N <= 1000
 N=2
 2
 N=3
 [3, 10, 5]

 3, 5 , 10

1,2,3,4,5
5
L=0
R=4

O(N^2)

5


 L = n
 R = m

 n * m

  5
3  10
    10
  5
3
3
   5
      10

3 10 5



[1,2,3]
2
1 to 1
3 to 3

3

[1,2,3,4,5]
root = 2
left = 1 to 1
right = 3 to 5


root = 4
left = 1 to 3
right = 5 to 5
 */

class FirstRound {
    public static void main(String[] args) {
        System.out.println(countBSTs(2));
        System.out.println(countBSTs(3));
        System.out.println(countBSTs(5));
    }

    private static long countBSTs(int n){
        if(n<=1)
            return n;

        long[] memo = new long[n+1];
        Arrays.fill(memo, -1l);
        return countBSTHelper(n, 1, n, memo);
    }

    private static long countBSTHelper(int n, int s, int e, long[] memo){
        if(s > e)
            return 0;
        if(memo[e-s+1] != -1){
            return memo[e-s+1];
        }
        if(e-s+1 == 1){
            return 1;
        }

        long numBsts = 0;
        for(int i=s; i<=e; ++i){
            long left = countBSTHelper(n, s, i-1, memo);
            long right = countBSTHelper(n, i+1, e, memo);
            if(left == 0)
                numBsts += right;
            else if(right == 0)
                numBsts += left;
            else
                numBsts += (left * right);
        }
        memo[e-s+1] = numBsts;
        return numBsts;

    }

}
