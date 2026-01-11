class Solution {
    static int dirs[][]={{1,0},{0,1},{-1,0},{0,-1}};
    void dfs(char grid[][], boolean vis[][], int r, int c){
        
        boolean isNotSafe = r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]
        =='0' || vis[r][c]==true;
        if(isNotSafe) return;
        // System.out.println("IN AT "+r+" "+c+" "+grid[r][c]);
        vis[r][c]=true;
        dfs(grid, vis, r+1, c);
        dfs(grid, vis, r-1, c);
        dfs(grid, vis, r, c+1);
        dfs(grid, vis, r, c-1);
    }
       
    public int numIslands(char[][] grid) {
        int h = grid.length, w=grid[0].length;
        boolean vis[][]=new boolean[h][w];
        int ans =0;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    dfs(grid, vis, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
}