package com.cmani.practice;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 */
public class SingleNumberFinding {
    public static int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int result =nums[0];
        for(int i=1; i<nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,1,3,4,5,6,6,7,3,4};
        System.out.println("Single Number in arrays: "+singleNumber(nums));
    }
}
