
/**
4,5,6,7,0,1,2


 */
class Solution {
    public int findMin(int[] nums) {
        int lb=0, ub=nums.length-1;
        while(lb<ub){
            int mid=(lb+ub)/2;
            // System.out.println(nums[mid]+" "+mid+" "+lb+" "+ub);
            if(nums[mid]<=nums[ub]){
                ub=mid;
            }else{
                //look right
                lb=mid+1;
            }
        }
        return nums[lb];
    }
}