class Solution 
{
    public int search(int[] nums, int target) 
    {
        int lb=0,ub=nums.length-1;
        int mid=lb+ (ub-lb)/2;
        while(lb<=ub){
            mid=lb+(ub-lb)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target)
                lb=mid+1;
            else
                ub=mid-1;
        }
        return -1;
    }
}