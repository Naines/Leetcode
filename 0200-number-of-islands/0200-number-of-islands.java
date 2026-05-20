class Solution {
    char grid[][];
    public int numIslands(char[][] grid) {
        int ans =0;
        this.grid=grid;
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    // System.out.println("start"+i+" "+j);
                    dfs(i, j, vis);
                    ans++;
                }
                

            }
        }
        return ans;
    }
    int dir[][]=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    void dfs(int x, int y, boolean vis[][]){
        if(x<0 || y<0 || x>=vis.length|| y>=vis[0].length|| vis[x][y] || grid[x][y]=='0'){
            return;
        }
        vis[x][y]=true;
        // System.out.println("in at "+x+" "+y+" "+grid[x][y]);
        for(int i=0;i<4;i++){
            int xx=x+dir[i][0], yy=y+dir[i][1];
            dfs(xx, yy, vis);
        }
    }
}