class Solution {

    //cases: 0 encounter, -ve are even

    public int maxProduct(int[] nums) {
        int maxP = nums[0], minP= nums[0],ans = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int t = maxP;
                maxP = minP;
                minP=t;
                // swap(maxP, minP);
            }
            maxP = Math.max(nums[i], nums[i]*maxP);
            minP = Math.min(nums[i], nums[i]*minP);
            ans = Math.max(maxP, ans);
        }
        return ans;
        
    }
}