package com.cmani.practice;

import java.util.Stack;

/**
 * validParentheses (){()}[] - valid
 */
public class ParenthesesCheck {

    public static boolean isValidParenthesesUse(String s){
        Stack<Character> stack = new Stack<>();
        if(s == null || s.isEmpty())
            return false;

        char[] chars = s.toCharArray();
        for(char c : chars){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(!stack.isEmpty() && (
                     (c == ')' && stack.peek() == '(') ||
                     (c == '}' && stack.peek() == '{') ||
                     (c == ']' && stack.peek() == '[')) ){
                stack.pop();
            }else if(c == ')' || c == '}' || c == ']'){
                return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        String str = "(){()}[]";
        boolean isValidExp = isValidParenthesesUse(str);
        System.out.println("Expression contains valid Parentheses combination: "+isValidExp);
    }
}
