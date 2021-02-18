package com.cmani.practice;

import java.util.Scanner;

public class CashRegister {

    public static final double QUARTER_VALUE = 0.25;
    public static final double DIME_VALUE = 0.1;
    public static final double NICKEL_VALUE = 0.05;
    public static final double PENNY_VALUE = 0.01;

  /*  NICKEL", .05M},
    {"DIME", .10M},
    {"QUARTER", .25M},
    {"HALF DOLLAR", .50M},
    {"ONE", 1.00M},
    {"TWO", 2.00M},
    {"FIVE", 5.00M},
    {"TEN", 10.00M},
    {"TWENTY", 20.00M},
    {"FIFTY", 50.00M},
    {"ONE HUNDRED", 100.00M}
*/
    private double purchase;
    private double payment;

    public CashRegister()
    {
        purchase = 0;
        payment = 0;
    }

    public void recordPurchase(double amount)
    {
        double newTotal = purchase + amount;
        purchase = newTotal;
    }

    public void enterPayment(int dollars, int quarters,
                             int dimes, int nickles, int pennies)
    {
        payment = dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE
                + nickles * NICKEL_VALUE + pennies * PENNY_VALUE;

    }

    public double giveChange()
    {
        double change = payment - purchase;
        purchase = 0;
        payment = 0;
        return change;
    }

    public int Counter(int purchase)
    {
        purchase = purchase + 1;
        return purchase;


    }
    public double getItemCount()
    {
        return purchase;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        CashRegister register = new CashRegister();

        System.out.print("Enter price: ");
        double price = in.nextDouble();
        register.recordPurchase(price);

        System.out.print("Enter dollars: ");
        int dollars = in.nextInt();
        System.out.print("Enter quarters: ");
        int quarters = in.nextInt();
        System.out.print("Enter dimes: ");
        int dimes = in.nextInt();
        System.out.print("Enter nickels: ");
        int nickels = in.nextInt();
        System.out.print("Enter pennies: ");
        int pennies= in.nextInt();
        register.enterPayment(dollars,  quarters, dimes, nickels, pennies);


        System.out.print("Your change: ");
        System.out.println(register.giveChange());

        System.out.println(register.getItemCount());

        System.exit(0);
    }
}
