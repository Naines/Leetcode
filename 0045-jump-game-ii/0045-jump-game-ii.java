class Solution {
    /**
     2,3,0,1,4
     0,1,1,2,2

     .........
     f[n]=Math.min(f[1]....f[n-1])+1
     */
    public int jump(int[] nums) {
        int n=nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                if (nums[j - 1] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n];
    }
}