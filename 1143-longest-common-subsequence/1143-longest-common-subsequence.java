class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m =text1.length(), n=text2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)!=text2.charAt(j-1))
                dp[i][j] = Math.max(dp[i][j-1], Math.max(dp[i-1][j], dp[i-1][j-1]));
                else{
                    dp[i][j]=dp[i-1][j-1]+1;
                    //System.out.println(i+" "+j);
                }
                //System.out.print(dp[i][j]+" ");
            }
            //System.out.println();
        }
        //printlcs(dp, m , n, text1, text2);
        return dp[m][n];
    }

    void printlcs(int dp[][], int m , int n, String text1,String text2){
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                lcs.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println(lcs.reverse().toString());
        
    }
}