package com.cmani.practice;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static List<String> calculateChangeAmount(int pp, int ch) {
        int change = ch - pp;
        int amount = 0;
        List<String> coins = new ArrayList<>();
        if (pp > ch) {
            coins.add("ERROR");
            return coins;
        } else if (pp == ch) {
            coins.add("ZERO");
            return coins;
        } else {
            change = change;
            amount = change / 10000;
            if (amount > 0) {
                change = change % 10000;
                coins.add("ONE HUNDRED");
            }
            amount = change / 5000;
            if (amount > 0) {
                change = change % 5000;
                coins.add("FIFTY");
            }
            amount = change / 2000;
            if (amount > 0) {
                change = change % 2000;
                coins.add("TWENTY");
            }

            amount = change / 1000;
            if (amount > 0) {
                change = change % 1000;
                coins.add("TEN");
            }
            amount = change / 500;
            if (amount > 0) {
                change = change % 500;
                coins.add("FIVE");
            }
            amount = change / 200;
            if (amount > 0) {
                change = change % 200;
                coins.add("TWO");
            }

            amount = change / 100;
            if (amount > 0) {
                change = change % 100;
                coins.add("ONE");
            }
            amount = change / 50;
            if (amount > 0) {
                change = change % 50;
                coins.add("HALF DOLLAR");
            }
            amount = change / 25;
            if (amount > 0) {
                change = change % 25;
                coins.add("QUARTER");
            }

            amount = change / 10;
            if (amount > 0) {
                change = change % 10;
                coins.add("DIME");
            }
            amount = change / 5;
            if (amount > 0) {
                change = change % 5;
                coins.add("NICKEL");
            }
            amount = change;

            coins.add("PENNY");

        }

        return coins;
    }


    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
         /*   InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
            BufferedReader in = new BufferedReader(reader);
            String line;
            while ((line = in.readLine()) != null) {

                String[] arr = line.split(";");
                int pp = (int) Math.round(Double.parseDouble(arr[0]));
                int ch = (int) Math.round(Double.parseDouble(arr[1]));*/
        int pp = (int) Math.round(15.29 * 100);
        int ch = (int) Math.round(16.00 * 100);
        List<String> result = calculateChangeAmount(pp, ch).stream().sorted().collect(Collectors.toList());

        System.out.println(String.join(",", result));

        //  }
    }
}
