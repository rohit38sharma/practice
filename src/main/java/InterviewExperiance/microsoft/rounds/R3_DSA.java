package InterviewExperiance.microsoft.rounds;

// you can also use imports, for example:
import java.util.*;
public class R3_DSA {

// ab*c
//abdecfc

// ab*cfc
//abdecfc

//abc
//abc**

//2, 4

//2, 4
public static void main(String [] args) {
    // you can write to stdout for debugging purposes, e.g.
    System.out.println(matchPattern("cb", "?a"));
}

    private static boolean matchPattern(String s, String p){
        int[][] memo = new int[s.length()+1][p.length()+1];
        for(int i=0;i<=s.length();++i){
            Arrays.fill(memo[i], -1);
        }
        return matchPatternHelper(s, p, 0, 0, memo);
    }

    private static boolean matchPatternHelper(String s, String p, int s_i, int p_i, int[][] memo){
        if(s_i < s.length() && p_i < p.length() && memo[s_i][p_i] != -1){
            return memo[s_i][p_i]==1;
        }

        if(s_i >= s.length() && p_i >= p.length()){
            return true;
        }

        if(s_i >= s.length()){
            if(p.charAt(p_i) == '*')
                return matchPatternHelper(s, p, s_i, p_i+1, memo);
            else
                return false;
        }

        if(p_i >= p.length()){
            return false;
        }

        boolean isMathed = false;

        if(isCharacter(p.charAt(p_i))){
            if(s.charAt(s_i) != p.charAt(p_i))
                isMathed = false;
            else{
                isMathed = matchPatternHelper(s, p, s_i+1, p_i+1, memo);
            }
        }else if(p.charAt(p_i) == '?'){
            isMathed = matchPatternHelper(s, p, s_i+1, p_i+1, memo);
        }else{
            for(int i=0;i<=s.length();++i){
                if(matchPatternHelper(s, p, s_i+i, p_i+1, memo)){
                    isMathed = true;
                    break;
                }
            }
        }

        if(isMathed){
            memo[s_i][p_i] = 1;
        }else{
            memo[s_i][p_i] = 0;
        }

        return isMathed;
    }

    private static boolean isCharacter(char c){
        if(c-'a' >=0 && c-'a'<26)
            return true;
        return false;
    }


}
