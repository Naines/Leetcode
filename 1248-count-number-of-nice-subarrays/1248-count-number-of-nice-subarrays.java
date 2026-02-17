class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // Map<Integer, Integer> map=new HashMap<>();
        // map.put(0, 1);
        // int l=0,n=nums.length, nodd=0;
        // int count=0;
        // for(int r=0;r<n;r++){
        //     if((nums[r]&1)==1) nodd++;
        //     count+=map.getOrDefault(nodd-k,0);
        //     map.put(nodd, map.getOrDefault(nodd,0)+1);
        // }
        // return count;

        return atmost(nums, k) - atmost(nums, k-1);
    }

    int atmost(int nums[], int k){
        if(k<0) return 0;
        int l=0, nodd=0, count=0;
        for(int r=0;r<nums.length;r++){
            if((nums[r]&1)==1) nodd++;
            while(nodd>k){
               if(nums[l]%2!=0){
                nodd--;
               }
               l++;
            }
            count+=r-l+1;
        }
        return count;
    }
}