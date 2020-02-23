package com.cmani.supplier;

import java.util.function.Supplier;

public class Supplier_Main {

    public static String getDBConnectionUrl(){
        return "jdbc://localhost:1516/testdb";
    }

    //Supplier uses
    public static Supplier<String> getDBConnectionUrlSupplier = ()-> "jdbc://localhost:1516/testdb";

    public static void main(String[] args) {
        System.out.println("--------------Without using supplier----------");
        System.out.println(getDBConnectionUrl());

        System.out.println("--------------With using supplier----------");
        System.out.println(getDBConnectionUrlSupplier.get());




    }
}
