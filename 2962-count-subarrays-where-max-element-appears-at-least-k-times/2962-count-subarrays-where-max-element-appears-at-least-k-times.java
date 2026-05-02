class Solution {

    public long countSubarrays(int[] nums, int k) {
        int maxEle = Integer.MIN_VALUE;
        for(int x: nums) maxEle = Math.max(maxEle, x);

        int l=0, maxFreq=0,n=nums.length;
        long ans=0;
        for(int r=0;r<n;r++){
            if(nums[r]==maxEle) maxFreq++;
            while(maxFreq>=k){
                if(nums[l]==maxEle)
                    maxFreq--;
                l++;
            }
            ans+=l;
        }
        return ans;
    }
}