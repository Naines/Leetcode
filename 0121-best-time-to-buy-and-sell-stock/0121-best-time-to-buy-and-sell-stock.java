class Solution {

    // 7 1 5 3 6 4
    // 7 1 5 3 6
    public int maxProfit(int[] prices) {
        int ans = Integer.MIN_VALUE;
        int buyAt = prices[0];
        for(int i=1;i<prices.length;i++){
            ans = Math.max(prices[i]-buyAt, ans);
            buyAt = Math.min(buyAt, prices[i]);
        }
        return ans<0?0:ans;
    }
}