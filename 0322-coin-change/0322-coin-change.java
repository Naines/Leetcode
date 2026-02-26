class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        // int memo[][] = new int[n + 1][amount + 1];
        // for (int i[] : memo)
        //     Arrays.fill(i, -1);
        int ans=minWays(n, coins, amount );    
        if(ans==Integer.MAX_VALUE-1)
            return -1;
        return ans;
    }
    //  static int minWays1(int n, int arr[], int sum, int memo[][]) {
    //     if (memo[n][sum] != -1)
    //         return memo[n][sum];
    //     if (sum == 0)
    //         memo[n][sum] = 0;
    //     else if (n == 0)
    //         memo[n][sum] = Integer.MAX_VALUE-1;
    //     else if (arr[n - 1] <= sum) {
    //         memo[n][sum] = Math.min(1 + minWays1(n, arr, sum - arr[n - 1], memo), minWays1(n - 1, arr, sum, memo));
    //     } else {
    //         memo[n][sum] = minWays1(n - 1, arr, sum, memo);
    //     }
    //     return memo[n][sum];
    // }
//     static int minWays(int n, int arr[], int sum) {
//         int dp[][] = new int[n + 1][sum + 1];
//         for (int i = 0; i <= n; i++)
//             dp[i][0] = 0;
//         for (int i = 1; i <= sum; i++)
//             dp[0][i] = Integer.MAX_VALUE - 1;

//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= sum; j++) {
//                 if (arr[i - 1] <= j)
//                     dp[i][j] = Math.min(1 + dp[i][j - arr[i - 1]], dp[i - 1][j]);
//                 else
//                     dp[i][j] = dp[i - 1][j];

//             }
//         }
//         return dp[n][sum];
//     }
    static int minWays(int n, int arr[], int sum) {
        // int dp[] = new int[sum + 1];
        // dp[0] = 0;
        // for (int i = 1; i <= sum; i++)
        //     dp[i] = Integer.MAX_VALUE - 1;

        // for (int i = 1; i <= n; i++) {
        //     for (int j = arr[i - 1]; j <= sum; j++) {

        //         dp[j] = Math.min(1 + dp[j - arr[i - 1]], dp[j]);

        //     }
        // }
        // return dp[sum];
        
        int dp[]=new int[sum+1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(arr[i-1]<=j)
                dp[j]=Math.min(1+dp[j-arr[i-1]], dp[j]);
            }
        }
        return dp[sum];
    }
}