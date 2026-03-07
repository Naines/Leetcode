class Solution {
    int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
    char board[][];
    String word ="";
    public boolean exist(char[][] board, String word) {
        int h =board.length, w=board[0].length;
        this.board = board;
        this.word = word;
        boolean vis[][]=new boolean[h][w];
        boolean res = false;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(word.charAt(0) == board[i][j] && vis[i][j]==false){
                    //System.out.println(i+" "+j);
                    res = res || dfs(i, j, vis, 0);
                }
            }
        }
        return res;
    }

    boolean dfs(int i, int j, boolean vis[][], int idx){
        if(idx==word.length()) return true;
        if(isillegal(i,j, vis, idx)) return false;
       // System.out.println("IN AT "+i+" "+j+" "+board[i][j]);
        vis[i][j]=true;
        boolean res = false;
        for(int k=0;k<4;k++){
            // if(isillegal(dirs[k][0]+i, dirs[k][1]+j, vis, idx+1)) continue;
            res = res || dfs(dirs[k][0]+i, dirs[k][1]+j, vis, idx+1);
        }
        vis[i][j]=false;
        return res;
    }

    boolean isillegal(int i, int j, boolean vis[][], int idx){
        return idx>word.length() || i<0 || j<0 || i>=board.length || j>=board[0].length || vis[i][j]==true || word.charAt(idx)!= board[i][j];
    }
}