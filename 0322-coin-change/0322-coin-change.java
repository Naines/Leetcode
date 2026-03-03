class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp[k] = ways to get sum k with given coins
        int dp[]=new int[amount+1];
        Arrays.fill(dp, (int)1e8);
        dp[0]=0;
        int n=coins.length;
        for(int i=1;i<=amount;i++){
            for(int j=1;j<=n;j++){
                if(i-coins[j-1]>=0)
                dp[i]=Math.min(dp[i], dp[i-coins[j-1]]+1);
            }
        } 
        System.out.println(Arrays.toString(dp));
        return dp[amount]==(int)1e8?-1:dp[amount];
    }
}