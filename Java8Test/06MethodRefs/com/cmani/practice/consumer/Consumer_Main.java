package com.cmani.practice.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Consumer_Main {
    //Java normal funtion for display Customer
    public static void greetCustomer(Customer customer){
        System.out.println("Thanks "+customer.customerName+" for registering  your customerNo is "+customer.customerNumber);
    }
    public static void greetCustomer(Customer customer,boolean showPhoneNumber){
        System.out.println("Thanks "+customer.customerName+" for registering  your customerNo is "+(showPhoneNumber?customer.customerNumber:"*********"));
    }
    //Using Consumer Functional Interface
    static Consumer<Customer> greetCustomer_With_Consumer =
            customer-> System.out.println("Thanks "+customer.customerName+" for registering  your customerNo is "+customer.customerNumber);
    static BiConsumer<Customer, Boolean> greetCustomer_With_BiConsumer =
            (customer,showPhoneNumber)-> System.out.println("Thanks "+customer.customerName+" for registering  your customerNo is "+(showPhoneNumber?customer.customerNumber:"*********"));

    public static void main(String[] args) {
        Customer chinta = new Customer("Chintamani Prasad","9895644348");
        //Using Normal funtion
        greetCustomer(chinta);
        greetCustomer(chinta,false);
        /* Using Consumer functional Interface */
        greetCustomer_With_Consumer.accept(chinta);
        greetCustomer_With_BiConsumer.accept(chinta,false);

    }

    static class Customer{
        private final String customerName;
        private final String customerNumber;

        Customer(String customerName, String customerNumber) {
            this.customerName = customerName;
            this.customerNumber = customerNumber;
        }

    }
}
