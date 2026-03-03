class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int x: nums) sum+=x;
        if(sum%2!=0) return false;

        sum=sum>>1;
        boolean dp[][]=new boolean[n+1][sum+1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(j-nums[i-1]>=0)
                dp[i][j]=dp[i-1][j-nums[i-1]]||dp[i-1][j];
                else dp[i][j]=dp[i-1][j];
            }
        }

        return dp[n][sum];
    }
}