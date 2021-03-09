package com.cmani.practice;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int [] arr){
        if(arr == null  || arr.length < 2){
            return;
        }else{
            mergeSort(arr, arr.length-1);
        }
    }

    private static void merge(int[] sortedArray, int[] l, int[] r, int low, int high) {
        int k = 0;
        int i =0;
        int j=0;
        //int mid = (low+high)/2;

        while(i < low && j < high){
            if(l[i] <= r[j]){
                sortedArray[k]=l[i];
                i++;
            }else{
                sortedArray[k]=r[j];
                j++;
            }
            k++;
        }
        while (i<low){
            sortedArray[k]=l[i];
            i++;
            k++;
        }
        while (j<high){
            sortedArray[k]=r[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void main(String[] args) {
        int[] unsortedArray = {1,5,6,2,7,9,3,10};
        System.out.println("------Unsorted Array------");
        Arrays.stream(unsortedArray).forEach(System.out::println);
        mergeSort(unsortedArray);
        System.out.println("------Sorted Array--------");
        Arrays.stream(unsortedArray).forEach(System.out::println);
    }
}
