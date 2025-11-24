class Solution {
    public int maxProfit(int[] prices) {
        
        for(int i=0;i<prices.length-1;i++){
            prices[i] = prices[i+1]-prices[i];
        }
        prices[prices.length-1] = 0;
        for(int x: prices) System.out.println(x);
        int sum =prices[0], max=prices[0];
        for(int i=1;i<prices.length;i++){
            sum = Math.max(prices[i] , sum + prices[i]);
            max= Math.max(max, sum);
        }
        return max<0?0:max;
    }
}