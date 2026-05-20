class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int ans =nums[0],sum=0;
        for(int i=0;i<n;i++){
            sum =Math.max(sum+nums[i], nums[i]);
            ans=Math.max(sum ,ans);
        }
        return ans;
    }
}