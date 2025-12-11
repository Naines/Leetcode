class Solution {

     public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;        
    }
    // public int numSubarrayProductLessThanK(int[] nums, int k) {
    //     if(k==0) return 0;
    //     int prd = 1;
    //     int ans=0;
    //     for(int j=0,start=0;j<nums.length;j++){
    //         //expand
    //         prd *=nums[j];
    //         //shrink, decrease window by increasing left/start ptr
    //         if(start<=j && prd>=k){
    //             prd = prd/nums[start++];
    //         }
    //         System.out.println(start+" "+j);
    //         ans+=j-start+1;
    //     }
    //     return ans;
    // }
}