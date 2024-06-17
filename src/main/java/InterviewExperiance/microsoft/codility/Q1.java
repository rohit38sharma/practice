package InterviewExperiance.microsoft.codility;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
public class Q1 {
    public int[] solution(String[] S) {
        int n = S.length;

        if(n == 0){
            return new int[0];
        }

        int m = S[0].length();

        for(int i=0;i<m;++i){
            Map<Character, Integer> visited = new HashMap<>();
            for(int j=0;j<n;++j){
                char c = S[j].charAt(i);
                if(visited.containsKey(c)){
                    return new int[]{visited.get(c), j, i};
                }
                visited.put(c, j);
            }
        }

        return new int[0];

    }
}
