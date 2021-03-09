package com.cmani.practice;

import java.util.Stack;

/**
 * Leetcode 227: sum of string value : 2+3*4-2/2*20-6
 */
public class BasicCalculatorTwo {

    public static int sumOfExpression(String s){
        if(null == s || s.isEmpty()){
            return 0;
        }
        int sum =0;
        char op = '+';
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<chars.length ;i++){

               // int num =0;
               // while(chars[i] >= '0' && chars[i] <= '9'){
                if(Character.isDigit(chars[i])){
                    sum = sum *10 + chars[i] - '0';
                   // num += num *10 + chars[i] - '0';
                }
                if(!Character.isDigit(chars[i]) && chars[i] != ' ' || i == chars.length-1){
                    if(op == '+'){
                        stack.push(sum);
                    }
                    else if(op == '-'){
                        stack.push(-sum);
                    }
                    else if(op == '*'){
                        stack.push(stack.pop() * sum);
                    }
                    else if(op == '/'){
                        stack.push(stack.pop()/sum);
                    }
                    op = chars[i];
                    sum = 0;
                }



        }
        int result =0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;

    }

    public static void main(String[] args) {
        int result = sumOfExpression("20+3*10");
        System.out.println("Sum of basic calculator two expression : "+result);
    }
}
