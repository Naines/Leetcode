class Solution {
    public int minPathSum(int[][] grid) {
        int INF = (int)1e8;
        int h=grid.length, w=grid[0].length;
        int dp[][]=new int[h+1][w+1];
        //BC
        dp[1][1]=grid[0][0];
        Arrays.fill(dp[0], INF);
        for(int i=0;i<=h;i++) dp[i][0] = INF;


        for(int i=1;i<=h;i++){
            for(int j=1;j<=w;j++){
                if(i==1 && j==1) continue;
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];  
            }
        }

        // display(dp);
        return dp[h][w];
        
    }
    void display(int dp[][]){
        int h=dp.length, w=dp[0].length;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}