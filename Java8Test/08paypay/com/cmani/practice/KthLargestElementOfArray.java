package com.cmani.practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementOfArray {
    //using heap : in java it has been implemented by priority queue


    public static int kthLargestElement(int[] arr, int k){
       /* PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            maxQueue.add(num);
            if(maxQueue.size()>(arr.length-k+1)){
                maxQueue.remove();
            }
        }
        return maxQueue.remove();*/

       PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for (int num : arr) {
            minQueue.add(num);
            if(minQueue.size()> k){
                minQueue.remove();
            }
        }
        return minQueue.remove();

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,8,9,10};
        System.out.println(kthLargestElement(arr,4));
    }
}
