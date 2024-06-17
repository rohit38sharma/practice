package InterviewExperiance.Roku;

/*
    Given two input strings - input1 and input2,

    Write a program to print the longest substrings of first input string (input1) without repeating characters that contains the all characters of second input string (input2) in any order

    If there are more than one longest substring return all of them


    Test Cases:

    #Case 1:
        Input Full String: abdefgabefbah
        Containing Str: aahh
        Output: efbah

        Input Full String: ahdefgaefbhazz
        Containing Str: ah
        Output: [ahdefg, hdefga, gaefbh, efbhaz]


        Input Full String: ahdefgabefbhazz
        Containing Str: ah
        Output: [hdefgab]

    # case 2:
        Input Full String: abcdefgh_98~!
        Containing Str: gf~!
        Output: abcdefgh_98~!


    # case 3:
        Input Full String: abcdefgh
        Containing Str: hz
        Output: ""
    */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Round1 {


    class Result {

        /*
         * Complete the 'longestSubstring' function below.
         *
         * The function is expected to return an List<String>.
         */

        public static List<String> longestSubstring(String input, String containedStr) {

            Set<Character> containings = scanContainingString(containedStr);

            return findAllLongestSubStrings(input, containings);
        }

        private static Set<Character> scanContainingString(String containedStr){
            Set<Character> containings = new HashSet<>();
            for(char c : containedStr.toCharArray()){
                containings.add(c);
            }

            return containings;
        }

        private static List<String> findAllLongestSubStrings(String input, Set<Character> containings){

            int n = input.length();

            Map<Character, Integer> visited = new HashMap<>();
            List<String> validSubStrings = new ArrayList<>();
            Set<Character> left = new HashSet<>(containings);

            int maxSubString = 0, len;

            int start = 0, end = 0;

            while(end < n){
                char cur = input.charAt(end);

                start = checkDuplicateandRemove(input, cur, visited, start, end,  containings, left);

                if(left.contains(cur)){
                    left.remove(cur);
                }

                visited.put(cur, end);


                len = end - start + 1;
                if(left.isEmpty() && len >= maxSubString){
                    if(len > maxSubString){
                        maxSubString = len;
                        validSubStrings = new ArrayList<>();
                    }
                    validSubStrings.add(input.substring(start, end+1));
                }

                ++end;
            }

            return validSubStrings;
        }

        private static int checkDuplicateandRemove(String input, char cur, Map<Character, Integer> visited, int start, int end,  Set<Character> containings, Set<Character> left){
            if(visited.containsKey(cur)){
                int idx = visited.get(cur);
                for(int i=start; i<=idx;++i){
                    char temp = input.charAt(i);
                    if(containings.contains(temp)){
                        left.add(temp);
                    }
                    visited.remove(temp);
                }
                start = idx + 1;
            }

            return start;
        }



    }


    public class Solution {
        public static void main(String[] args) throws IOException {
            /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            String inp = "abcdefgh";
            String containedStr = "af";

            List<String> result = Result.longestSubstring(inp, containedStr);


            bufferedWriter.write(result);
            bufferedWriter.newLine();

            bufferedWriter.close();*/

            List<String> result1 = Result.longestSubstring("abdefgabefbah", "aahh");

            for(String res : result1){
                System.out.println(res);
            }

            System.out.println();

            List<String> result2 = Result.longestSubstring("ahdefgaefbhazz", "ah");

            for(String res : result2){
                System.out.println(res);
            }

            System.out.println();

            List<String> result3 = Result.longestSubstring("ahdefgabefbhazz", "ah");

            for(String res : result3){
                System.out.println(res);
            }


            List<String> result4 = Result.longestSubstring("abcdefgh_98~!", "gf~!");

            for(String res : result4){
                System.out.println(res);
            }

            System.out.println();


            List<String> result5 = Result.longestSubstring("abcdefgh", "hz");

            for(String res : result5){
                System.out.println(res);
            }

            System.out.println();

        }

    }

}
