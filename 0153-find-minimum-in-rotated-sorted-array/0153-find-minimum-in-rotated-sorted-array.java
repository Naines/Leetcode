class Solution {
    public int findMin(int[] nums) {
        int lb=0, ub=nums.length-1;
        while(lb<ub){
            int m = (lb+ub)/2;
            if(nums[m]>nums[ub]){
                lb= m+1;
            }else{
                ub=m;
            }
        }
        return nums[lb];
    }
}