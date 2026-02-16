class Solution {
    public boolean exist(char[][] board, String word) {
        int h = board.length, w =board[0].length;
        boolean vis[][]=new boolean[h][w];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if (word.charAt(0)==board[i][j] && dfs(i, j, board, word.toCharArray(), vis,0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(int r, int c, char board[][], char word[], boolean vis[][], int idx){
        if(idx==word.length) return true;
        if(isLegal(r,c, board, vis, word[idx])){
           vis[r][c]=true;
            if(dfs(r+1, c, board, word, vis, idx+1) ||
            dfs(r-1, c, board, word, vis, idx+1) ||
            dfs(r, c+1, board, word, vis, idx+1) ||
            dfs(r, c-1, board, word, vis, idx+1)
            )return true;
           vis[r][c]=false; 
        }
        return false;
    }

    boolean isLegal(int r, int c, char board[][], boolean vis[][], char ch){
        return r>=0 && c>=0 && r<board.length && c<board[0].length && !vis[r][c] && board[r][c]==ch ;
    }
}