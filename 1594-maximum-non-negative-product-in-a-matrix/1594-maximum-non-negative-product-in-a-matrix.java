class Solution {
    //move (i,j+1) or (i+1,j)
    //maxProd = max(maxPrd, ans)
    //minPrd = min(minPrd, ans)
    //if(cellVal<0){swap(maxPrd, minPrd)}

    int grid[][];
    int mod = 1000000007;
    long ans=-1;
    public int maxProductPath(int[][] grid) {
        this.grid = grid;
        int curr=grid[0][0];
        dfs(0,0, curr);
        return (int)(ans%mod);
    }

    void dfs(int i, int j, long curr){
        if(i==grid.length-1 && j==grid[0].length-1){
            ans = Math.max(ans, curr);
            return;
        }
        if(grid[i][j]==0){
            ans=Math.max(ans, 0);
            return;
        }

        if(i+1<grid.length)
            dfs(i+1, j, curr*grid[i+1][j]);
        if(j+1<grid[0].length)
            dfs(i, j+1, curr*grid[i][j+1]);
    }
}