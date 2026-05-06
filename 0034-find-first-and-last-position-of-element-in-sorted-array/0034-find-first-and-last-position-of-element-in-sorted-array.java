class Solution {

    //5 7 7 8 8 10
    //0 1 2 3 4 5
    //f t t f f f      
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int first = lower(nums, target);
        int last = upper(nums, target);

        first = nums[first]==target?first:-1;
        last = nums[last]==target?last:-1;
        return new int[]{first, last};
    }


    int lower(int nums[], int target){
        int lb=0, ub=nums.length-1;
        int ans=0;
        while(lb<=ub){
            int mid=(lb+ub)/2;
            if(nums[mid]>=target){
                ans=mid;
                ub=mid-1;
            }else{
                lb=mid+1;
            }
        }
        return ans;
    }

     int upper(int nums[], int target){
        int lb=0, ub=nums.length-1;
        int ans=0;
        while(lb<=ub){
            int mid=(lb+ub)/2;
            if(nums[mid]<=target){
                ans=mid;
                lb=mid+1;
            }else{
                ub=mid-1;
            }
        }
        return ans;
    }
}