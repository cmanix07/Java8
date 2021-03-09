package com.cmani.practice;

import java.util.Arrays;
import java.util.Stack;

/**
 * Leetcode 224: sum of string value : 2+3+(4-2+(9+20)-6)
 */

public class BasicCalculatorOne {

    public static int findSumOfGivenExpression(String s) {
        int sum = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length;i++) {
            if(chars[i] >= '0' && chars[i] <= '9'){
                int num =0;
                while(i< chars.length && Character.isDigit(chars[i])){
                    num = num*10 + chars[i] - '0';
                    i++;
                }
                sum += num*sign;
                i--;
            }
            else if(chars[i] == '+'){
                sign = 1;
            }
            else if(chars[i] == '-'){
                sign = -1;
            }
            else if(chars[i] == '('){
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }
            else if(chars[i] == ')'){
                sum = stack.pop()*sum;
                sum += stack.pop();
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        int result = findSumOfGivenExpression("2+3");
        System.out.println("Sum of expression: "+result);
    }
}
