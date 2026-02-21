class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length, l=0;
        double sum=0.0;
        for(int i=0;i<k;i++) sum+=nums[i];
        double maxAvg = sum/k;
        System.out.println(maxAvg);
        for(int r=k;r<n;r++){
           sum+=nums[r]-nums[r-k];
           maxAvg = Math.max(maxAvg, sum/k);
            System.out.println(maxAvg);
        }

        return maxAvg;
    }
}