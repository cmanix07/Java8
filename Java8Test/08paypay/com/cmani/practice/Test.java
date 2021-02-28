package com.cmani.practice;

import java.text.DecimalFormat;

public class Test {
    public static void main(String[] args) {
        DecimalFormat money = new DecimalFormat("0.00");
        System.out.println(money.format(10.00935));
        if(money.format(10.00935).equals("10.01")){
            System.out.println(money.format(10.00935).equals("10.01"));
        }


    }
}
