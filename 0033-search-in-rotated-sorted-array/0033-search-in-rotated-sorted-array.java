class Solution {

    //4,5,6,7,0,1,2   0
    //f f f f t t t
    //4,5,6,7,0,1,2   3
    public int search(int[] nums, int target) {
        int lb=0, ub=nums.length-1;
       while(lb<=ub){
            int m = (lb+ub)>>1;
            if(nums[m]==target) return m;
            //left side sorted?
            if(nums[lb]<=nums[m]){
                //if sorted, then target lies within [lb..m]?
                if(target>=nums[lb] && target<=nums[m])
                    ub=m-1;
                else
                    lb=m+1;
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