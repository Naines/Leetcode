class Solution {
    /**
        dirs[][]={{},{},{},{},{},{}}
        c==1, go right or left
        c==2, go up/down
        c==3, go left/down
        c==4, go right/down
        c==5, go left/up
        c==6, go up/right 
     */
    int grid[][];
    int dirs[][][]={
        {{0,1},{0,-1}},
        {{1,0},{-1,0}},
        {{0,-1},{1,0}},
        {{0,1},{1,0}},
        {{0,-1},{-1,0}},
        {{0,1},{-1,0}}
    };
    public boolean hasValidPath(int[][] grid) {
       this.grid=grid;
       boolean vis[][]=new boolean[grid.length][grid[0].length];
       Queue<int[]> q = new LinkedList<>();
       q.add(new int[]{0,0});
       vis[0][0]=true;
       while(q.size()>0){
        int t[]=q.poll();
        int num=grid[t[0]][t[1]]-1;
        for(int dir[]: dirs[num]){
            int xx=t[0]+dir[0], yy=t[1]+dir[1];
            if(xx<0 || yy<0 || xx>=grid.length || yy>=grid[0].length 
            || vis[xx][yy]==true) continue;

            //next cell is in conjunction w/ this cell dir
            for(int bd[]: dirs[grid[xx][yy]-1]){
                if(xx+bd[0]==t[0] && yy+bd[1]==t[1]){
                    vis[xx][yy]=true;
                    q.add(new int[]{xx, yy});
                }
            }
        }
       }
       return vis[grid.length-1][grid[0].length-1];
    }
}