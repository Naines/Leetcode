class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int max=0;
        for(int i=1;i<prices.length;i++){

            //max: max profit till date if i sell today
            max=Math.max(max+prices[i]-prices[i-1], max);
            ans=Math.max(ans, max);
        }
        return ans;
    }
}