package dev.algos.snatch.interview_problems.array;

import java.util.HashMap;
import java.util.Map;

/**
 * ### [Two Sum](https://leetcode.com/problems/two-sum/)
 * Difficulty: **Easy**
 * <p>
 * Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.
 * You may assume that each input would have **_exactly_** one solution, and you may not use the _same_ element twice.
 * <p>
 * *Example:**
 * ```
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * ```
 */
class TwoSum {


    /**
     * Time complexity
     * O(n)
     * Space complexity
     * O(n)
     */
    int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
