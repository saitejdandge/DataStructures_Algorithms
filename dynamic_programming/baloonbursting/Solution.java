package dynamic_programming.baloonbursting;

import java.util.HashMap;

/*
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 16

*/
public class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    public int maxCoins(int[] nums) {
        int newData[] = new int[nums.length + 2];
        newData[0] = 1;
        newData[newData.length - 1] = 1;
        for (int i = 0; i < nums.length; i++)
            newData[i + 1] = nums[i];
        return solve(newData, 1, newData.length - 1);
    }

    public int solve(int[] nums, int i, int j) {
        if (i >= j)
            return 0;

        if (map.get(i + "_" + j) != null)
            return map.get(i + "_" + j);

        int ans = Integer.MIN_VALUE;
        ;
        for (int k = i; k <= j - 1; k++) {

            if (map.get(i + "_" + k) == null)
                map.put(i + "_" + k, solve(nums, i, k));

            int left = map.get(i + "_" + k);

            if (map.get((k + 1) + "_" + j) == null)
                map.put((k + 1) + "_" + j, solve(nums, k + 1, j));

            int right = map.get((k + 1) + "_" + j);

            int temp = left + right + (nums[i - 1] * nums[k] * nums[j]);
            ans = Math.max(ans, temp);
        }
        map.put(i + "_" + j, ans);
        return ans;
    }
}