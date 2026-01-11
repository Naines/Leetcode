class Solution {
    static int dirs[][]={{1,0},{-1,0},{0, 1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int h = grid.length, w= grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int cf=0, ans=0;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(grid[i][j]==2)
                    q.add(new int[]{i, j});
                else if(grid[i][j]==1)
                    cf++;
            }
        }
       
        if(cf==0) return 0;
        
        while(!q.isEmpty()){
            ans++;
            int size= q.size();
            while(size-->0){
                int t[]= q.poll();
                for(int dir[]: dirs){
                    int x = t[0]+ dir[0];
                    int y = t[1]+ dir[1];
                    if(x < 0 || y < 0 || x >= h|| y >=w || grid[x][y] == 0 ||
                    grid[x][y] == 2)
                        continue;
                    grid[x][y]=2;
                    q.add(new int[]{x,y});
                    cf--;
                }
            }
        }
        return cf>0?-1:ans-1; 

    }
}