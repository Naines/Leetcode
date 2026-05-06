class Solution {
    //1 3 5 6
    //f t t t
    public int searchInsert(int[] nums, int target) {
        int lb=0, ub=nums.length-1;
        int ans=-1;
        while(lb<=ub){
            int mid=lb+(ub-lb)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) ub=mid-1;
            else lb=mid+1;
        }
        return lb;
    }
}