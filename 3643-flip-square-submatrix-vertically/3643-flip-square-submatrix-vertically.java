class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        flip(x, y, k, grid);
        return grid;
    }

    //1,0,3,
    //3,2,3
    //3

    //0,2,2
    //1,3,2

    void flip(int x, int y, int k, int grid[][]){
        
        for(int i=0;i<k/2;i++){
            for(int j=0;j<k;j++){
                int t = grid[x+i][y+j];
                grid[x+i][y+j]=grid[x+k-i-1][y+j];
                grid[x+k-i-1][y+j]=t;
            }
        }
    }
}