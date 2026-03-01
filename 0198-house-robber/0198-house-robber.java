class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int dp[]=new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0]=nums[0];
        if(nums.length>1) dp[1]=Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;i++){
            if(i>1)
                dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length-1];
    }
}