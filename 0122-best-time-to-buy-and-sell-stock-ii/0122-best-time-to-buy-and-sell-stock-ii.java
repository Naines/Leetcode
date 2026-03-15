class Solution {

    //if buyAt < currPrice
    //buy
    public int maxProfit(int[] prices) {
        int buyAt = prices[0], profit = 0;
        for(int i=1;i<prices.length;i++){

            if(buyAt>prices[i]){
                buyAt = prices[i];
            }else{
                profit+=prices[i]-buyAt;
                buyAt = prices[i];
            }
        }
        return profit;
    }
}