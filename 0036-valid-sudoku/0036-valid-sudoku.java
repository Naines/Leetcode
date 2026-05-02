class Solution {

    public boolean isValidSudoku(char[][] board) {
      boolean row[][]=new boolean[10][10];
      boolean col[][]=new boolean[10][10];
      boolean grid[][]=new boolean[10][10];
      int r=board.length, c=board[0].length;
      for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            if(board[i][j]=='.') continue;
            if(isNotValid(i, j, row, col, grid, board)){
                return false;
            }
            row[i][board[i][j]-'0']= true;
            col[j][board[i][j]-'0']= true;
            int gridPos = getGridPos(i, j);
            grid[gridPos][board[i][j]-'0'] = true;
        }
      }
        // print(grid);
      return true;
    }
    boolean isNotValid(int x, int y, boolean row[][], boolean col[][], boolean grid[][], char board[][]){
        char c=board[x][y];
        //check if c, is not already in same, row, col, grid
        int ggp = getGridPos(x, y);
        return row[x][c-'0'] || col[y][c-'0'] || grid[ggp][c-'0'];
    }
    int getGridPos(int h, int w){
        int wx=w/3, hy=h/3;
        int gridpos = (hy*3)+wx;
        return gridpos;
    }

    // void print(boolean mat[][]){
    //     int h=mat.length, w=mat[0].length;
    //     for(int i=0;i<h;i++){
    //         for(int j=0;j<w;j++){
    //             System.out.print((mat[i][j]?1:0)+" ");
    //         }
    //         System.out.println();
    //     }
    // }
}