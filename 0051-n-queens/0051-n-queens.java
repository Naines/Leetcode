class Solution {
    List<List<String>> ans = new ArrayList<>();
    boolean grid[][];
    boolean col[], diag1[], diag2[];
    public List<List<String>> solveNQueens(int n) {
        this.grid=new boolean[n][n];
        this.col = new boolean[n];
        this.diag1=new boolean[2*n-1];
        this.diag2=new boolean[2*n-1];
        solve(0, n);
        return ans;
    }

    void solve(int cr, int n){
        if(cr==n){
            addToAnswer(grid,n);
            return;
        }

        for(int i=0;i<n;i++){
            if(!canPlace(col, diag1, diag2, cr, i, n, n)) continue;
            col[i]=true;
            diag1[cr-i+n-1]=true;
            diag2[cr+i]=true;
            grid[cr][i]= true;
            solve(cr+1, n);
            col[i]=false;
            diag1[cr-i+n-1]=false;
            diag2[cr+i]=false;
            grid[cr][i]=false;
        }
    }
    boolean canPlace(boolean col[], boolean diag1[], boolean diag2[],
     int x, int y, int h, int w){
        if(col[y]) return false;
        if(diag1[x-y+h-1]) return false;
        if(diag2[x+y]) return false;
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