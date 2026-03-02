class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        StringBuilder sb = longestCommonSubsequence(str1, str2);
        // String lcs = sb.toString();
        // //System.out.println(lcs);
        // int p = 0, i = 0;

        // //ab, abac, cab
        // //abacc
        // while (i < str1.length()) {
        //     if(p==lcs.length()) {
        //         sb.append(str1.charAt(i++));
        //         continue;
        //     }
        //     if (str1.charAt(i) == lcs.charAt(p)) {
        //         p++;
        //         i++;
        //     } else {
        //         sb.append(str1.charAt(i));
        //         i++;
        //     }
        // }
        // p = 0;
        // i = 0;
        // while (i < str2.length()) {
        //     if (p == lcs.length()) {
        //         sb.append(str2.charAt(i++));
        //         continue;
        //     }
        //     if (str2.charAt(i) == lcs.charAt(p)) {
        //         p++;
        //     } else {
        //         sb.insert(0,str2.charAt(i));
        //     }
        //     i++;
        // }
        return sb.toString();
    }
    public StringBuilder longestCommonSubsequence(String text1, String text2) {
        int m =text1.length(), n=text2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)!=text2.charAt(j-1))
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                else{
                    dp[i][j]=dp[i-1][j-1]+1;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int i=m, j=n;
        while(i>0 && j>0){
             if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                sb.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(text1.charAt(i-1));
                i--;
            } else {
                sb.append(text2.charAt(j-1));
                j--;
            }
        }

        while (i > 0) {
            sb.append(text1.charAt(i-1));
            i--;
        }
        while (j > 0) {
            sb.append(text2.charAt(j-1));
            j--;
        }
        return sb.reverse();
    }
}