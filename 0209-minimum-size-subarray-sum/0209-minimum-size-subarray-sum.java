class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = nums.length+1;
        int sum = 0;
        int start = 0;
        for(int i=0;i<nums.length;i++){

            //update
            sum += nums[i];

            //shrink until valid
            while(sum >= target && start <= i){
                ans = Math.min(ans , i - start + 1); //update
                sum -= nums[start++];
            }  
        }
        return ans==nums.length+1?0:ans;
    }
}