class Solution {
     public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    
   static boolean solve(char board[][]){
       for(int i=0;i<9;i++){
           for(int j=0;j<9;j++){
                if(board[i][j]!='.') continue;
                for(char c='1';c<='9';c++){
                    if(!isValid(board, i, j, c)) continue;
                    board[i][j]=c;
                    if(solve(board)) return true;
                    board[i][j]='.';
                }
                return false; //0-9 nothing worked
           }
       }
       return true; //all . filled
    }
    static boolean isValid(char board[][], int x, int y, char k) {
        for(int j=0;j<9;j++)
            if(board[x][j]==k) 
             return false;

        for(int i=0;i<9;i++)
            if(board[i][y]==k)
              return false;

        int gridx=x/3*3,
            gridy=y/3*3;
        for(int i=0;i<9;i++){
            if(board[gridx+i/3][gridy+i%3]==k)
             return false;
        }
        return true;
    }
}