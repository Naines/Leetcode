class Solution {
    // size n - k over the array.
    // The answer is max(answer, total_pts - sumOfCurrentWindow)
    public int maxScore(int[] nums, int k) {
      int n=nums.length, l=0, ans=0;
      k = n-k;
      int totalSum= Arrays.stream(nums).sum(), sum=0;
      int x=0;
      for(int r=0;r<n;r++){
        if(r<k-1) {
            sum+=nums[r];
            continue;
        }
        sum+=nums[r];
        if(r-l+1>k){
            sum-=nums[l++];
        }
        ans=Math.max(ans, totalSum - sum);
        System.out.println(l+" "+r+" "+ans+" "+sum);
      }  
      return ans;
    }
}