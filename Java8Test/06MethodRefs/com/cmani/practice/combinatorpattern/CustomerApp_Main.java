package com.cmani.practice.combinatorpattern;

import java.time.LocalDate;

public class CustomerApp_Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Aadhya","aadhya@email.com",
                "+917795203204", LocalDate.of(1995,01,15));

        CustomerValidatorService validatorService = new CustomerValidatorService();
        boolean isValid = validatorService.isValidustomer(customer);
        System.out.println(isValid);
        //If customer is valid then stor in DB

        //Using combinatorPattern
        Customer customer2 = new Customer("Aadhya","addhya@email.com",
                "7795203204",LocalDate.of(2019,01,15));
            CustomerRegistrationValidator.ValidationResult result= CustomerRegistrationValidator.isEmailValid()
                    .and(CustomerRegistrationValidator.isPhoneNumberValid())
                    .and(CustomerRegistrationValidator.isAnAdult())
                    .apply(customer2);

        System.out.println(result);
            if(!result.equals(CustomerRegistrationValidator.ValidationResult.SUCCESS)){
               throw  new IllegalArgumentException(result.name());
            }
    }
}
