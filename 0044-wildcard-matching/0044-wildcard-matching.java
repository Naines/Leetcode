class Solution {
    //dp[i][j] = states if first j char matches first i char
    //if ? -> dp[i][j] = dp[i-1][j-1] 
    //if * -> dp[i][j] = dp[i-1][j] || dp[i][j-1]
    //else char c - macth > dp[i][j] = dp[i-1][j-1]
    //else dont match -> dp[i][j]=false 
    public boolean isMatch(String s, String p) {
        int m=s.length(), n=p.length();
        boolean dp[][]=new boolean[m+1][n+1];
        dp[0][0]=true; //"",""
        for(int i=1;i<=n;i++){
            if(p.charAt(i-1)=='*') {
                dp[0][i]=dp[0][i-1];
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-1]||dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}