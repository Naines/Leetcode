class Solution {
    public long countSubarrays(int[] nums, long k) {
        int l=0,r=0;
        long ans =0 , currSum = 0;
        for(r=0;r<nums.length;r++){
            currSum+=nums[r];
            while(currSum*(r-l+1)>=k){
                currSum-=nums[l++];
            }
            ans+=r-l+1;
        }
        return ans;
    }
}