class Solution {
    /**
    k=2
    1,2,3,1,2 -> 1,2,3

     */
    public int subarraysWithKDistinct(int[] nums, int k) {
      return atMostK(nums, k)-atMostK(nums, k-1);
    }

    int atMostK(int nums[], int k){
        if(k<0) return 0;
        int map[]=new int[20010];
        int count = 0,ans=0, l=0;
        for(int r=0;r<nums.length;r++){
            //add
            map[nums[r]]++;
            if(map[nums[r]]==1) count++; //add for first time
            while(count>k){
                //remove
                map[nums[l]]--;
                if(map[nums[l]]==0) count--; //remove
                l++;
            }
            ans+=(r-l+1);
        }
        return ans;
    }
}