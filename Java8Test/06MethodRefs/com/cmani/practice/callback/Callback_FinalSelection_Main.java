package com.cmani.callback;

import java.util.function.Consumer;

public class Callback_FinalSelection_Main {

    public static void main(String[] args) {

        hello("John","montana",value-> System.out.println("No Name provided"+value));
        hello("Chinta",null,value-> System.out.println("No lastName provided for "+value));

        //without args
        hello2("Prasad",null,()-> System.out.println("No last name provided"));

    }

    public static void hello(String firstName, String lastName, Consumer<String> callback){
		System.out.println(firstName);
		if (lastName != null)
			System.out.println(lastName);
		else
		    callback.accept(firstName);
	}

    public static void hello2(String firstName, String lastName, Runnable callback){

        System.out.println(firstName);
        if (lastName != null)
            System.out.println(lastName);
        else
            callback.run();
    }
}
