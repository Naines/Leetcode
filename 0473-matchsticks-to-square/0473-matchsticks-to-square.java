class Solution {
    int arr[];
    int len, trgt;
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if(sum%4!=0){
            return false;
        }
        Arrays.sort(matchsticks);
        this.arr = matchsticks;
        this.len = matchsticks.length;
        this.trgt = sum/4;
        return dfs(0, 0, 4, new boolean[len]);//currSum, currIdx, k
    }

    boolean dfs(int currSum, int idx, int k, boolean vis[]){
        if(k==0) return true;
        if(currSum==trgt) return dfs(0, 0, k-1, vis);
        for(int i=idx;i<len;i++){
            if(vis[i]) continue;
            if(arr[i]+currSum> trgt) continue;

            vis[i]=true;
            if(dfs(currSum+arr[i], i+1, k, vis)) return true;
            vis[i]=false;
        }
        return false;
    }
}