class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean grid[][]=new boolean[n][n];
        solve(grid, 0, n);
        return ans;
    }

    void solve(boolean grid[][], int cr, int n){
        if(cr==n){
            addToAnswer(grid,n);
            return;
        }

        for(int i=0;i<n;i++){
            if(!canPlace(grid, cr, i, grid.length, grid[0].length)) continue;
            grid[cr][i]=true;
            solve(grid, cr+1, n);
            grid[cr][i]=false;
        }
    }
    boolean canPlace(boolean grid[][], int x, int y, int h, int w){
        //up, right Diag, left diag
        for(int i=x-1;i>=0;i--){
            if(grid[i][y]) return false;
        }
        int i=x-1, j=y-1;
        while(i>=0 && j>=0){
            if(grid[i--][j--]) return false;
        }
        i=x-1; j=y+1;
        while(i>=0 && j<w){
            if(grid[i--][j++]) return false;
        }
        return true;
    }
    void addToAnswer(boolean grid[][],int n){
        List<String> temp=new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb= new StringBuilder();
            for(int j=0;j<n;j++){
                if(grid[i][j])
                  sb.append('Q');
                else
                  sb.append('.'); 
            }
            temp.add(sb.toString());
        }
        ans.add(temp);
    }
}