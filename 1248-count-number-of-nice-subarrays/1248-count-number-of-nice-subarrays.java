class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k)-atMostK(nums, k-1);
    }

    int atMostK(int nums[], int k){
        if(k<0) return 0;
        int n=nums.length, ans=0, l=0, count=0;
        for(int r=0;r<n;r++){
            if(nums[r]%2!=0) count++;
            while(count>k){
                if(nums[l]%2!=0) count--;
                l++;
            }
            //count<=k at this point
            ans+=r-l+1;
        }
        return ans;
    }
}