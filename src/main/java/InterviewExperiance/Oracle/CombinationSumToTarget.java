package InterviewExperiance.Oracle;

import java.util.ArrayList;
import java.util.List;

/**
 Input: {2,3,4,5,-2}
 Target = 10
 -12,2,5,5,5,5
 Output = { [2,2,2,2,2], [2,3,5] , [5,5] ....}

 O(n^n)

 */
public class CombinationSumToTarget {
    private List<List<Integer>> combinations;

    public List<List<Integer>> findCombinationSumToTarget(int[] nums, int target){
        combinations = new ArrayList<>();
        int n = nums.length;
        if(n==0)
            return combinations;
        helper(nums, target, 0, new ArrayList<Integer>());

        return combinations;
    }

    private void helper(int[] nums, int target, int curSum, ArrayList<Integer> path){
        if(curSum == target){
            combinations.add(new ArrayList<>(path));
            return;
        }

        if(curSum > target){
            return;
        }
        //Case1: curSum > target
        //Case2: curSum < target
        for(int i=0;i<nums.length;++i){
            path.add(nums[i]);
            helper(nums, target, curSum + nums[i], path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSumToTarget solution = new CombinationSumToTarget();
        int[] input = {5,2,3,4};
        int target = 10;
        List<List<Integer>> allCombinations = solution.findCombinationSumToTarget(input, target);

        for(List<Integer> list : allCombinations){
            for(int num : list){
                System.out.print(num);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
