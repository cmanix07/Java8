package com.cmani.predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Predicate_Main {
    public static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("91") && phoneNumber.length() == 12;
    }
    public static boolean isPhoneNumberValidForCountry(String phoneNumber, String country){
        return phoneNumber.startsWith("91") && country.equals("INDIA");
    }

    public static Predicate<String> isPhoneNumberValidWithPredicate =
            phoneNumber->phoneNumber.startsWith("91") && phoneNumber.length()==12;

    public static Predicate<String> isPhoneNumberContains77WithPredicate =
            phoneNumber->phoneNumber.contains("77");

    public static BiPredicate<String,String> isPhoneNumberValidForCountryWithBiPredicate =
             (phoneNumber,country)->phoneNumber.startsWith("91") && country.equalsIgnoreCase("INDIA");


    public static void main(String[] args) {
        System.out.println("------------Without using predicate----------");
        System.out.println(isPhoneNumberValid("917795203204"));
        System.out.println(isPhoneNumberValid("9895644348"));
        System.out.println(isPhoneNumberValid("919611635274"));

        System.out.println("-------------With using Predicate------------");
        System.out.println("Predicate Expected TRUE: "+isPhoneNumberValidWithPredicate.test("917795203204"));
        System.out.println("Predicate Expected FALSE: "+isPhoneNumberValidWithPredicate.test("9895644348"));
        System.out.println("Predicate Expected TRUE: "+isPhoneNumberValidWithPredicate.test("919611635274"));

        System.out.println("Predicate with AND another Predicate condition Expected TRUE: "
                +isPhoneNumberValidWithPredicate.and(isPhoneNumberContains77WithPredicate).test("917795203204"));
        System.out.println("Predicate with AND another Predicate condition Expected FALSE: "
                +isPhoneNumberValidWithPredicate.and(isPhoneNumberContains77WithPredicate).test("919611635274"));

        System.out.println("-----------With using BiPredicate---------------");
        System.out.println("BiPredicate Expected TRUE: "+isPhoneNumberValidForCountryWithBiPredicate.test("917795203204","INDIA"));
        System.out.println("BiPredicate Expected FALSE: "+isPhoneNumberValidForCountryWithBiPredicate.test("919895644348","JAPAN"));

    }
}
