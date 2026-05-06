class Solution {

    //5 7 7 8 8 10
    //0 1 2 3 4 5
    //f t t f f f      
    public int[] searchRange(int[] nums, int target) {
        int ans = lower(nums, target);
        if(ans == nums.length || nums[ans] !=target){
            return new int[]{-1,-1};
        }
        return new int[]{ans, lower(nums, target+1)-1};
    }

    int lower(int nums[], int target){
        int lb=0, ub=nums.length;
        while(lb<ub){
            int mid=(lb+ub)/2;
            if(nums[mid]<target){
                lb=mid+1;
            }else{
                ub=mid;
            }
        }
        return lb;
    }
}