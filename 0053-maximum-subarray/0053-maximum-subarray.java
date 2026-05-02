class Solution {
    /** 
    prefix max So Far
     */
    public int maxSubArray(int[] nums) {
        int ans =Integer.MIN_VALUE, sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            sum=Math.max(sum, nums[i]);
            ans=Math.max(ans, sum);
        }
        return ans;
    }
}