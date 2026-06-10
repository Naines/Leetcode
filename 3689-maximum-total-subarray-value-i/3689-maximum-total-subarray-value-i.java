class Solution {
    /**
        132 32 2 13 3 1
        31=2
        1
        0 2  0 0 //ans:4

        4251
        91287

        Observation: 
        1. Max Values * k times.

    */
    public long maxTotalValue(int[] nums, int k) {
        int max = -1, min = Integer.MAX_VALUE, maxDiff=0;
        long ans = 0;
        for(int n: nums){
            max=Math.max(max, n);
            min = Math.min(min, n);
            maxDiff = Math.max(maxDiff, max-min);
        }
        // System.out.println(maxDiff);
        ans = (long)maxDiff*k; //74768090670
        return ans;
    }
}