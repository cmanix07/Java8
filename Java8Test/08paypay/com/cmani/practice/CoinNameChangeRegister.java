package com.cmani.practice;


import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CoinNameChangeRegister {


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

        Map<String,Integer> output = calculateChange(15.29,16.00);
        output.forEach((key, value) -> System.out.println(key+"  "+ value));

        //  }
    }

    public enum CoinsName{
        ONE_HUNDRED  ("ONE HUNDRED",100.00),
        FIFTY ("FIFTY",50.00),
        TWENTY("TWENTY",20.00),
        TEN("TEN",10.00),
        FIVE("FIVE",5.00),
        TWO("TWO",2.00),
        ONE("ONE",1.00),
        HALF_DOLLAR("HALF DOLLAR",0.50),
        QUARTER("QUARTER",.25),
        DIME("DIME",.10),
        NICKEL("NICKEL",.05),
        PENNY("PENNY",.01);
        //DEFAULT("ZERO",0.00);

        private final String key;
        private final double value;


        CoinsName(String key, double value) {
            this.key=key;
            this.value=value;
        }
        public String getKey(){
            return key;
        }
        public double getValue(){
            return value;
        }

        private static Map<String,CoinsName> reverseLookup = Arrays.stream(CoinsName.values()).collect(Collectors.toMap(CoinsName::getKey, Function.identity()));

        public static CoinsName getCoinStatus(String key){
            return CoinsName.reverseLookup.get(key);
        }

    }

    public static Map<String,Integer> calculateChange(Double pp, Double ch){
        Map<String,Integer> output =  new HashMap<>();
        DecimalFormat formatter = new DecimalFormat("0.00");

        //cover to integer and perform operation
        Integer change = (int)(Double.parseDouble(formatter.format(ch - pp)) * 100);
        if((change%100) < 0){
            output.put("ERROR",change);
        }else if((change%100) == 0 ){
            output.put("ZERO",change);
        }else {
            Iterator<CoinsName> it = Arrays.stream(CoinsName.values()).iterator();
            while (it.hasNext()) {
                CoinsName coinsName = it.next();
                int coinValueInt = (int)(Double.parseDouble(formatter.format(coinsName.value)) * 100);
                int noOfCoinsReturned = change/coinValueInt;
                Integer amount = change - coinValueInt*noOfCoinsReturned;
                if (amount >= 0 && noOfCoinsReturned > 0) {
                    output.put(coinsName.getKey(),noOfCoinsReturned);
                    change = amount;
                }

            }
        }

        return output;

    }
}
