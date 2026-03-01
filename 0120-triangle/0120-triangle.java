class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int INF = (int)1e8;
        int h=triangle.size(), w=triangle.get(h-1).size();
        int dp[][]=new int[h+1][w+1];
        //BC
        dp[1][1]=triangle.get(0).get(0);
        Arrays.fill(dp[0], INF);
        for(int i=0;i<=h;i++) dp[i][0] = INF;


        for(int i=1;i<=h;i++){
            for(int j=1;j<=w;j++){
                if(i==1 && j==1) continue;
                if(j>i) {
                    dp[i][j]=INF;
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i-1).get(j-1);  
            }
        }
        for(int i=0;i<=h;i++){
            for(int j=0;j<=w;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        int ans = dp[h][1];
        for(int i=1;i<=w;i++){
            ans = Math.min(dp[h][i], ans);
        }
        return ans;
    }
}