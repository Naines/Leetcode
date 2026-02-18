class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans = lower(nums, target);
        if(ans == nums.length || nums[ans] !=target){
            return new int[]{-1,-1};
        }
        return new int[]{ans, lower(nums, target+1)-1};
    }

    int lower(int a[], int t){
        int lb=0, ub=a.length;
        while(lb<ub){
            int m= lb+(ub-lb)/2;
            if(a[m]<t){
                lb=m+1;
            }else{
                ub=m;
            }
        }
        return lb;
    }
    
}