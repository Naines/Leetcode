class Solution {
    
    public int uniquePaths(int m, int n) {
         return solveHelper(m-1, n-1, new int[n][m]);  
    }

    static int solveHelper(int m, int n, int memo[][] ){
        if (m < 0 || n < 0) {
            return 0;
        } else if (m == 0 && n == 0) {
            //destination
            return 1;
        } else if (memo[n][m] > 0) {
            return memo[n][m];
        }else {
            memo[n][m] = solveHelper(m - 1, n, memo) + solveHelper(m, n - 1, memo);
            return memo[n][m];
        }
    }
}