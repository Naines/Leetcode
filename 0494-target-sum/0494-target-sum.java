class Solution {
    int nums[];
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
       this.nums = nums;
        dfs(target, 0);
        return count;
    }

    void dfs(int target, int idx){
        if(idx==nums.length){
            if(target==0){
                count++;
            }
            return;
        }

        dfs(target+nums[idx], idx+1);
        dfs(target-nums[idx], idx+1);
    }
}