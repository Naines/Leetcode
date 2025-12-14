class Solution {
    ArrayList<List<String>> ans=new ArrayList<>();//store ans
    public List<List<String>> solveNQueens(int n) {
       
        boolean grid[][]=new boolean[n][n];
        solve(grid, n, 0);
        return ans;
    }
     void solve(boolean grid[][], int n, int cr)
    {
        if(cr==n)
        {
            add(grid,n);
            return;
        }
        
        for(int i=0;i<n;i++)
        {
            if(isSafe(grid, n, cr, i))
            {
                //place queen
                grid[cr][i]=true;
                
                //place more queen in next row onwards
                solve(grid, n, cr+1);
                    
                //remove queen ..finding next possibility
                grid[cr][i]=false;
                
            }
        }
    }
    void add(boolean grid[][], int n)
    {
        ArrayList<String> temp=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            String s="";
            for(int j=0;j<n;j++)
            {
                if(grid[i][j])  s+='Q';
                    else s+='.';
            }
            temp.add(s);
        }
        ans.add(temp);
    }
    boolean isSafe(boolean grid[][], int n, int r, int c)
    {
        //upward attack
        for(int i=r-1;i>=0;i--)
            if(grid[i][c])     return false;
        
        //upward left diag
        for(int i=r-1, j=c-1;j>=0 && i>=0 ;i--,j--)
            if(grid[i][j])  return false;
        //upward right diag
        for(int i=r-1, j=c+1;j<n && i>=0 ;i--,j++)
            if(grid[i][j])  return false;
        //no side ways ckeck req
        return true;
    }
}