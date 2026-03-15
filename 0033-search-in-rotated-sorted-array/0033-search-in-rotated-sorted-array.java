class Solution {
    public int search(int[] nums, int target) {
        int lb = 0, ub = nums.length-1;
        while(lb<=ub){
            int m = (lb+ub)/2;
            if(nums[m]==target){
                return m;
            }
            if(nums[lb]<=nums[m]){

                if(nums[lb]<=target && target<=nums[m]){
                    ub = m-1;
                }else{
                    lb=m+1;
                }

            }else{
                
                if(target>=nums[m] && target<=nums[ub]){
                    lb=m+1;
                }else{
                    ub=m-1;
                }
            }
        }
        return -1;
    }
}