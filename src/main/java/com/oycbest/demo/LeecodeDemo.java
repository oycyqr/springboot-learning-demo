package com.oycbest.demo;

import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/7/17 11:32 下午
 */
public class LeecodeDemo {
    public static void main(String[] args) {
        System.out.println("Leetcode Demo");
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] sum = new LeecodeDemo().twoSum(nums, target);
        Arrays.stream(sum).forEach(s-> System.out.println(s));
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j] && i != j) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
