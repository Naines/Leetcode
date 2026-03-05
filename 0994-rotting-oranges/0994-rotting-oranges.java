class Solution {
    //add rotten to queue
    //every second pop all from queue and add neighbours to queue
    //at end, check if there are fresh oranges left
    //if cnt>0 return -1

    public int orangesRotting(int[][] grid) {
        int cnt = 0, time=0;
        int h=grid.length, w=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(grid[i][j]==1) cnt++;
                else if(grid[i][j]==2) q.add(new int[]{i, j});
            }
        }
        // 2,1,1
        // 1,1,0
        // 0,1,1

        // 2,1,1
        // 0,1,1
        // 1,0,1
        if(cnt==0) return 0;
        int dir[][]= {{1,0},{-1,0},{0,1},{0,-1}};

        while(q.size()>0){
            int size = q.size();
            for(int j=0;j<size;j++){
                int t[]=q.poll();
                //System.out.println(t[0]+" "+t[1]+" "+grid[t[0]][t[1]]);
                for(int i=0;i<4;i++){
                    int cr = t[0]+dir[i][0];
                    int cc= t[1]+dir[i][1];
                    if(cr>=0 && cc>=0 && cr<h && cc<w && grid[cr][cc]==1){
                        cnt--;
                        q.add(new int[]{cr, cc});
                        grid[cr][cc]=2;
                    }
                }
            }
            //System.out.println("time = "+time);
            time++;
        }
        return cnt>0?-1:time-1;
    }
}