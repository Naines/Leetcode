class Solution {
    public int searchInsert(int[] nums, int target) {
        int lb=0, ub=nums.length-1;
        int ans = nums.length;
        while(lb<=ub){
            int m = lb+(ub-lb)/2;
            if(nums[m]>=target){
                ans=m;
                ub=m-1;
            }else lb=m+1;
        }
        return ans;
    }
}