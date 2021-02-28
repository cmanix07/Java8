package com.cmani.practice.funcation;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Function_Main {
    public static int incrementByOne(int num){
        return num+1;
    }
    public static Function<Integer,Integer> incrementByOneFunction = num->num+1;
    public static Function<Integer,Integer> incrementMultiplyBy10Function = num->num*10;

    public static int incrementByOneAndMultiply(int numToIncrement, int numToMultiplyBy){
        return (numToIncrement+1) * numToMultiplyBy;
    }
    //BI Functional
    public static BiFunction<Integer,Integer,Integer> incrementByOneAndMultiplyBiFunction =
            (numToIncrement,numToMultiplyBy) -> (numToIncrement +1) * numToMultiplyBy;

    public static void main(String[] args) {
        //Normal way to call method static;
        int incrementedNo = incrementByOne(1);
        System.out.println("Normal static method call: "+incrementedNo);
        int incrementedNo_2 = incrementByOneFunction.apply(1);
        System.out.println("Function java call: "+incrementedNo_2);

        System.out.println("--Apply increment thenApply multiply by 10 function--");
        Function<Integer,Integer> multiplyBy10 = incrementByOneFunction.andThen(incrementMultiplyBy10Function);
        System.out.println(multiplyBy10.apply(4));

        //Using cutome java function
        System.out.println(incrementByOneAndMultiply(9,100));
        //using inbuilt java BiFunction
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(9,100));

    }
}
