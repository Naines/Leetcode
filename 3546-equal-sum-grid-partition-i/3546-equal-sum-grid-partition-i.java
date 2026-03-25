class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int h=grid.length, w=grid[0].length;
        long prefix[][]=new long[h+1][w+1];
        for(int i=1;i<=h;i++){
            for(int j=1;j<=w;j++){
                prefix[i][j]=prefix[i-1][j]+prefix[i][j-1]+grid[i-1][j-1]-prefix[i-1][j-1];
            }
        }
        //print(prefix);
        if(prefix[h][w]%2!=0) return false;
        long required = prefix[h][w]/2;
        for(int i=1;i<h;i++) if(prefix[i][w]==required) return true;
        for(int i=1;i<w;i++) if(prefix[h][i]==required) return true;
        return false;
    }
    void print(long mat[][]){
        int h=mat.length, w=mat[0].length;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

    }
}