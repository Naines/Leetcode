class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, target);
    }

    int dfs(int a[], int i, int t){
        if(i==a.length) return t==0?1:0;
        return dfs(a, i+1, t-a[i])+dfs(a, i+1, t+a[i]);
    }
}