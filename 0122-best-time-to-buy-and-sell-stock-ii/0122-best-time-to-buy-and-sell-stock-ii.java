class Solution {
    //profit booking based on price for prev day
    public int maxProfit(int[] prices) {
        int ans=0, max=0;
        for(int i=1;i<prices.length;i++){
            //max: max profit till date if I sell today
            max=Math.max(max+prices[i]-prices[i-1], max);
            ans=Math.max(ans, max);
        }
        return ans;
    }
}