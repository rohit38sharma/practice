package InterviewExperiance.microsoft.codility;

public class Q3 {
    public int solution(String S) {
        int n = S.length();
        if(n <= 1){
            return 0;
        }

        int longestSubStr = 0;
        boolean[][] valid = new boolean[n][n];

        for(int i=0;i<n;++i){
            valid[i][i] = false;
        }

        for(int i=0;i<n-1;++i){
            valid[i][i+1] = isValid(S.charAt(i), S.charAt(i+1));
            if(valid[i][i+1]){
                longestSubStr = 2;
            }
        }

        for(int len=3; len<=n;++len){
            for(int i=0; i< n-len+1; ++i){
                int j = i + len - 1;
                if(len % 2 == 1){
                    valid[i][j] = false;
                    continue;
                }
                if(valid[i+1][j-1] && isValid(S.charAt(i), S.charAt(j))){
                    valid[i][j] = true;
                    longestSubStr = len;
                }else{
                    valid[i][j] = false;
                }
            }
        }

        return longestSubStr;
    }

    private boolean isValid(char a, char b){
        if(a == '<' && (b == '>' || b == '?')){
            return true;
        }

        if(a == '?' && (b == '>' || b == '?')){
            return true;
        }

        return false;
    }
}
