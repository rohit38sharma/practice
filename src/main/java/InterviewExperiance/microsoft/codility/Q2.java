package InterviewExperiance.microsoft.codility;
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
public class Q2 {
    public int solution(int U, int[] weight) {
        int n = weight.length;
        if(n == 0)
            return 0;
        if(n == 1){
            return weight[0] <= U ?0 :1;
        }

        int minRemove = 0;
        Stack<Integer> canCross = new Stack<>();
        int cur, top;

        for(int i=0; i<n; ++i){
            cur = weight[i];
            while(!canCross.isEmpty() && (cur + canCross.peek()) > U){
                top = canCross.pop();
                cur = Math.min(cur, top);
                ++minRemove;
            }
            if(cur <= U){
                canCross.push(cur);
            }
        }

        return minRemove;
    }
}
