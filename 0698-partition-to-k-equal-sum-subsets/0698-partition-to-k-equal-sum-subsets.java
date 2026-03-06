class Solution {
    int k, trgt,len;
    int nums[];
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int x: nums) sum+=x;
        if(sum%k!=0) return false;
        this.nums = nums;
        this.k = k;
        this.trgt = sum/k;
        this.len = n;
        System.out.println(trgt);
        return dfs(0, k, 0, new boolean[len]); //state - currSum, currGrp, currIdx
    }

    boolean dfs(int currSum, int k, int idx, boolean vis[]){
        // System.out.println("IN AT: "+idx+" "+k+" "+currSum);
        if(k==0){
            return true;
        }
        if(currSum==trgt) return dfs(0, k-1, 0, vis);

        for(int i=idx;i<len;i++){
            if(vis[i]) continue;
            if(currSum+nums[i]>trgt) continue;
            vis[i]=true;
            if (dfs(currSum+nums[i], k, i+1, vis))
            return true;
            vis[i]=false;
        }

        return false;
    }
}