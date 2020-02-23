package com.cmani.optional;

import java.util.Optional;

public class Optional_Main {

    public static void main(String[] args) {
        Object value= Optional.ofNullable("Hello").orElseGet(()->"default Value");
        System.out.println(value);

        //If value is null
        Optional.ofNullable("Email@email").ifPresent(System.out::println);
        Optional.ofNullable(null).ifPresent(email-> System.out.println("Email id is present: "+email)); //null no output Consumer return void
        System.out.println(Optional.ofNullable(null).orElseGet(()-> "default value")); //Supplier with arg return value

        System.out.println(Optional.ofNullable(null).isPresent()); //return boolean
        Optional.ofNullable(null).orElseThrow(()->new IllegalArgumentException("Null value passed !")); //Supplier without arg return value
       //Optional uses
    }


}
