class Solution {

    //12123
    //11221
    //
    //map.size()!=k
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums, k)-solve(nums, k-1);
    }

    int solve(int nums[], int k){
        if(k<0) return 0;
       int map[]=new int[20001];
       int l=0, ans=0, count =0;
       for(int r=0;r<nums.length;r++){
            map[nums[r]]++;
            if(map[nums[r]]==1) count++;

            while(count>k){
                map[nums[l]]--;
                if(map[nums[l]]==0) count--;
                l++;
            }
           
            ans+=(r-l+1);
       }
       return ans;
    }
}