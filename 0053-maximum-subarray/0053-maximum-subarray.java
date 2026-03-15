class Solution {

    //find the range sum, if range sum<maxSum, reset range start
    //maxSum = -Infinity


    //-2,1,-3,4,-1,2,1,-5,4
    // -2, -1, -4,
    // 4 -1 
    public int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int maxEnd=nums[0], maxSum= nums[0];
        int cs = 0, s=0, e=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]+maxEnd < nums[i]){
                maxEnd = nums[i];
                cs = i;
            }else{
                maxEnd = nums[i]+maxEnd;
            }
            
            if(maxEnd > maxSum){
                maxSum = maxEnd;
                s=cs;
                e=i;
            }
        }
        System.out.println(s+" "+e);
        return maxSum;
    }
}