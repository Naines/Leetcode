class Solution {

    /**
    DFS:
    (0,0) -> (0,1) -> (0,2) ...

     */
     int dirs[][]={{-1,0},{1,0},{0,-1},{0,1}};
     char[][] grid;
    public boolean containsCycle(char[][] grid) {
        int h=grid.length, w=grid[0].length;
        this.grid=grid;
        boolean vis[][]=new boolean[h][w];
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(vis[i][j]) continue;
                if(dfs(i, j, vis, grid[i][j], i, j)) return true;
                // System.out.println("here");
            }
        }
        return false;
    }

    boolean dfs(int x, int y, boolean vis[][], char c, int px, int py){
        vis[x][y]=true;
        // System.out.println(x+" "+y+" "+grid[x][y]+" "+px+" "+py);
        for(int i=0;i<4;i++){
            int xx=x+dirs[i][0];
            int yy=y+dirs[i][1];
            if(xx>=0 && yy>=0 && xx<vis.length && yy<vis[0].length && grid[xx][yy]==c){
                if(vis[xx][yy]==false) {
                    // System.out.println("next is "+xx+" "+yy);
                    if(dfs(xx, yy, vis, c, x, y)==true) return true;
                }else if(vis[xx][yy] && (px!=xx || py!=yy)){
                    // System.out.println("cycle detected");
                    return true;
                }
            }
        }
        return false;
    }
}