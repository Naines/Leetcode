class NumMatrix {

    int pre[][];
    public NumMatrix(int[][] matrix) {
        int h=matrix.length, w=matrix[0].length;
        pre=new int[h+1][w+1];

        for(int i=1;i<=h;i++){
            for(int j=1;j<=w;j++){
                pre[i][j]=pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1]+matrix[i-1][j-1];
            }
        }

    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        r1++;
        c1++;
        r2++;
        c2++;
        return pre[r2][c2] - pre[r2][c1-1] - pre[r1-1][c2] + pre[r1-1][c1-1]; 
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */