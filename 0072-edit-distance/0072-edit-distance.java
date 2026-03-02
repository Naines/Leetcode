class Solution {
    public int minDistance(String word1, String word2) {
        return longestCommonSubsequence(word1, word2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m =text1.length(), n=text2.length();
        int dp[][]=new int[m+1][n+1];
        dp[0][0]=Integer.MAX_VALUE;
        for(int i=0;i<=n;i++) dp[0][i]=i;
        for(int i=0;i<=m;i++) dp[i][0]=i;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)!=text2.charAt(j-1))
                dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]))+1;
                else{
                    dp[i][j]=dp[i-1][j-1];
                    //System.out.println(i+" "+j);
                }
                //System.out.print(dp[i][j]+" ");
            }
            //System.out.println();
        }
        //printlcs(dp, m , n, text1, text2);
        return dp[m][n];
    }
}