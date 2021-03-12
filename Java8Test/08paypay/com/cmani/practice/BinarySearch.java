package com.cmani.practice;

public class BinarySearch {

        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];
            result[0] = search(nums, target, false);
            result[1] = search(nums, target, true);

            return result;
        }
        // I have take flag to determine the leftSearch or RightSearch
        int search(int[] nums, int target, boolean flag) {

            int l = 0;
            int r = nums.length - 1;

            while(l <= r) {
                int mid = (l + r) >>> 1;

                if(nums[mid] == target) {
                    if(flag) {
                        if(mid + 1 < nums.length && nums[mid + 1] == target) {
                            l = mid + 1;
                        }
                        else
                            return mid;
                    }
                    else {
                        if(mid - 1 > -1 && nums[mid - 1] ==  target) {
                            r = mid - 1;
                        }
                        else
                            return mid;
                    }

                }

                else if(nums[mid] < target) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }

            return -1;
        }

}
