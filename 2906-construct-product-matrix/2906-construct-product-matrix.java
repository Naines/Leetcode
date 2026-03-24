class Solution {
    //prefix p
    //suffix p 
    // 1234
    // pre: 1,2,6,24
    // suffix: 24,24,12,4
    // ans: 24, 12, 8, 6

    //1,2
    //3,4
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;

        int size = n * m;
        long[] arr = new long[size];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[idx++] = grid[i][j];
            }
        }

        long[] prefix = new long[size + 1];
        long[] suffix = new long[size + 1];
        prefix[0] = 1;
        suffix[size] = 1;

        for (int i = 0; i < size; i++) {
            prefix[i + 1] = (prefix[i] * arr[i]) % mod;
        }

        for (int i = size - 1; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] * arr[i]) % mod;
        }

        int[][] p = new int[n][m];
        for (int k = 0; k < size; k++) {
            int i = k / m;
            int j = k % m;
            p[i][j] = (int)(prefix[k] * suffix[k + 1]) % mod;
        }

        return p;
    }
    
    // public int[][] constructProductMatrix(int[][] grid) {
    //     long p =1;
    //     int mod=12345;
    //     int h=grid.length, w=grid[0].length;
    //     long pre[][]=new int[h+1][w+1];
    //     long suff[][]=new int[h+1][w+1];
    //     for(int i=0;i<=h;i++) {
    //         Arrays.fill(pre, 1);
    //         Arrays.fill(suff, 1);
    //     }  
    //     for(int i=1;i<=h;i++){
    //         for(int j=1;j<=w;j++){
    //             pre[i][j] = (pre[i - 1][j] * pre[i][j - 1]*grid[i-1][j-1] / pre[i - 1][j - 1])%mod; 
    //         }
    //     }
    //      for(int i=h;i>=1;i--){
    //         for(int j=w;j>=0;j--){
    //             suff[i][j] =(suff[i+1][j] * suff[i][j+1]*grid[i-1][j-1]/  suff[i+1][j+1])%mod;
    //     }
    //     for(int i=0;i<h;i++){
    //         for(int j=0;j<w;j++){
    //             grid[i][j]=(prefix[i][j]*suffix[i][j])%mod;
    //         }
    //     }
    //     return grid;
    // }
}