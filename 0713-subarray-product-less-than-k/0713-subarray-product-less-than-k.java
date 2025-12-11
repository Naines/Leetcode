class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0) return 0;
        int l=0, prd=1, ans=0;
        for(int r=0;r<nums.length;r++){
            prd*=nums[r];
            //shrink window if prd>=k
            while(prd>=k && l<=r){
                prd/=nums[l++];
            }
            ans+= r-l+1;
        }
        return ans;
    }
}