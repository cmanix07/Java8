package com.cmani.practice;

import java.util.Arrays;

public class CoinChangeCountWays {

    //amountToGet = amount to get, m array size
    public static long coinCountWay(int[] arr, int arrayLength, int amountToGet){
        // Time complexity of this function: O(mn)

        // table[i] will be storing the number of solutions
        // for value i. We need amountToGet+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (amountToGet = 0)
        long[] table = new long[amountToGet+1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(amountToGet)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<arrayLength; i++)
            for (int j=arr[i]; j<=amountToGet; j++)
                table[j] += table[j-arr[i]];

        return table[amountToGet];
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        int amount = 4;
        int arrSize = arr.length;
        System.out.println("Possible solution to get change "+ amount +" from given coin ways "+coinCountWay(arr,arrSize,amount));
    }
}
