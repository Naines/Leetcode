class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], ans =sum;
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            if(sum < nums[i]){
                sum = nums[i] ;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}