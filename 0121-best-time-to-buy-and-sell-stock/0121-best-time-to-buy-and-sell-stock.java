class Solution {
    public int maxProfit(int[] prices) {  
        if(prices.length==1) return 0;   
        int buyAt = prices[0]; 
        int profit = 0;
        for (int price : prices) {
            if(buyAt > price)
                buyAt = price;
            profit = Math.max(profit, price - buyAt);
            //System.out.println(buyAt+" "+price+" "+profit);
        }
        return profit;
    }
}