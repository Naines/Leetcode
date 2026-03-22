class Solution {
    public void rotate(int[][] matrix) {
        int h=matrix.length, w=matrix[0].length;
        for(int i=0;i<h/2;i++){
            reverse(matrix, i);
        }
        for(int i=0;i<h;i++){
            for(int j=i+1;j<w;j++){
                int t = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
    }

    void reverse(int mat[][], int r){
        int w=mat[0].length, h = mat.length;
        for(int i=0;i<w;i++){
            int t=mat[r][i];
            mat[r][i]=mat[h-r-1][i];
            mat[h-r-1][i]=t;
        }
    }
}