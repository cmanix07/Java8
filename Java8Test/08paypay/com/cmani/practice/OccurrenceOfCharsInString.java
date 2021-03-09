package com.cmani.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Frequency of each characters in words
 */
public class OccurrenceOfCharsInString {

    public static Map<Character, Integer> frequencyOfChars(String s){
        Map<Character, Integer> frequencyMap = new HashMap<>();
        char [] chars = s.toCharArray();
        for (char c : chars) {
            if(frequencyMap.containsKey(c)){
                frequencyMap.put(c,frequencyMap.get(c)+1);
            }else{
                frequencyMap.put(c,1);
            }
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String to find the frequency of chars");
        Map<Character,Integer> resultMap = frequencyOfChars(sc.next());
        resultMap.forEach((key,val)->{
            System.out.println(key +"  "+val);
        });
    }
}
