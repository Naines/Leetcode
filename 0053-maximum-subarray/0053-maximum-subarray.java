class Solution {
    public int maxSubArray(int[] nums) {
      //5,4,-1,7,8
      int sum = nums[0], maxSoFar = nums[0];
      for(int i=1;i<nums.length;i++){
        //get local maxima
        sum = Math.max(sum+nums[i], nums[i]);

        //get global maximum
        maxSoFar = Math.max(maxSoFar, sum);
      }

      return maxSoFar;
    }
}