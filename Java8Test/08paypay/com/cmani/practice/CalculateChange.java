package com.cmani.practice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculateChange {

/*
    static String CalculateChangeAmount(String purchasePriceCash) {
        Double purchasedPrice = Double.parseDouble(purchasePriceCash.split(";")[0]);
        Double Cash = Double.parseDouble(purchasePriceCash.split(";")[1]);
        List<String> changedCoins = new ArrayList<String>();
        if (Double.compare(Cash, purchasedPrice) == -1) {
            return "ERROR";
        } else if (Double.compare(purchasedPrice, Cash) == 0) {
            return "ZERO";
        } else {
            Double getChange = Double.sum(Cash, -purchasedPrice);
            if (!String.IsNullOrEmpty(billCoinCollection.FirstOrDefault(coins = > coins.Value == getChange).Key))
            {
                return billCoinCollection.FirstOrDefault(coins = > coins.Value == getChange).Key;
            }

            List<string> coinsList = calculateChangeFromRegister(getChange, changedCoins);
            return String.Join(",", coinsList.OrderBy(x = > x).ToArray());/
        }
    }

    static List<String> calculateChangeFromRegister(Double change, List<String> changedCoins)
    {
        String registerkey = billCoinCollection.FirstOrDefault(coins => coins.Value == change).Key;
        if (!String.IsNullOrEmpty(registerkey))
        {
            changedCoins.Add(registerkey);
            return changedCoins;
        }
        var tempCoins = billCoinCollection.Where(coins => coins.Value <= change).ToDictionary(p => p.Key, p => p.Value);
        decimal gotAmount = tempCoins.Values.Max();
        changedCoins.Add(billCoinCollection.FirstOrDefault(coins => coins.Value == gotAmount).Key);
        decimal remainingAmount = Decimal.Subtract(change, gotAmount);
        return calculateChangeFromRegister(remainingAmount, changedCoins);
    }*/

}