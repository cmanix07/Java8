package com.cmani.practice.funcational;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.cmani.practice.funcational.Main.Gender.*;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("john", MALE),
                new Person("Archana", FEMALE),
                new Person("Aadhya", FEMALE),
                new Person("Prasad", MALE)
        );

        //imperative approach
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }
        System.out.println("// Imperative approach");
        for (Person female:females) {
            System.out.println(female);
        }

        //Declarative approach
        System.out.println("// Declarative approach");
        people.stream().filter(person -> FEMALE.equals(person.gender)).collect(Collectors.toList()).forEach(System.out::println);

    }
         static class Person{

             private final String name;
             private final Gender gender;

             Person(String name, Gender gender){
                this.name=name;
                this.gender=gender;
             }

             @Override
             public String toString() {
                 return "Person{" +
                         "name='" + name + '\'' +
                         ", gender=" + gender +
                         '}';
             }
         }
        enum Gender {
        MALE,FEMALE
        }

}
