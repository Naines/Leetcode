class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        int h = board.length, w=board[0].length;

        //first, last column
        for(int r=0;r<h;r++){
            if(board[r][0]=='O') 
                dfs(board, r, 0);
            if(board[r][w-1]=='O') 
                dfs(board, r, w-1);
        } 

        for(int c=0;c<w;c++){
            if(board[0][c]=='O') 
                dfs(board, 0, c);
            if(board[h-1][c]=='O')
                dfs(board, h-1, c);
        }

        for(int r=0;r<h;r++){
            for(int c=0;c<w;c++){
                if(board[r][c]=='O')
                    board[r][c]='X';
                else if(board[r][c]=='#')
                    board[r][c]='O';
            }
        }
    }

    void dfs(char[][] board, int r, int c) {
        int m = board.length;
        int n = board[0].length;

        if(r < 0 || c < 0 || r >= m || c >= n || board[r][c] != 'O')
            return;

        board[r][c] = '#';

        for(int[] d : dirs) {
            dfs(board, r + d[0], c + d[1]);
        }
    }
}