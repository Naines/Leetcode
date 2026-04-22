class Solution {
    /**
     2,3,0,1,4
     0,1,1,2,2

     .........
     f[n]=Math.min(f[1]....f[n-1])+1
     */
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, currMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currMax = Math.max(currMax, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = currMax;
            }
        }
        return jumps;
    }
}