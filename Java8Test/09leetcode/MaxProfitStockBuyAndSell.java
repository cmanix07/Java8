/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
 * https://www.youtube.com/watch?v=WLV0oLY5-FE&ab_channel=jayatitiwari
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 *
 * Use logic to get maximum water b/w two towers
 */

public class MaxProfitStockBuyAndSell {
    
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0; i<prices.length; i++){
            if(min>prices[i]){
                min = prices[i];
            }else if(profit < prices[i]-min){
                profit = prices[i]-min;
            }
        }
        return profit;
    }
    
    public int maxProfitUsingRainWaterHarvestingProblem(int[] prices){
        int maxProfit = 0;
        int minSoFar = prices[0];
        for(int i=0; i<prices.length; i++){
            minSoFar = Math.min(minSoFar,prices[i]);
            int profit = prices[i]-minSoFar;
            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
}
