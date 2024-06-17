package com.rohit.practice.leetcode.Array;

public class LT75SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int i0 = 0, i2 = n-1, curr = 0;


        while(curr <= i2){
            if(nums[curr] == 0){
                int temp = nums[curr];
                nums[curr] = nums[i0];
                nums[i0] = temp;

                ++curr;
                ++i0;
            }else if(nums[curr] == 2){
                int temp = nums[curr];
                nums[curr] = nums[i2];
                nums[i2] = temp;

                --i2;
            }else{
                ++curr;
            }
        }
    }

    public void sortColors1(int[] nums) {
        int n = nums.length;
        int[] count = new int[3];

        for(int num : nums){
            count[num]++;
        }

        int i=0;
        for(int c=0; c<3; ++c){
            while(count[c]-- > 0){
                nums[i++] = c;
            }
        }
    }
}
