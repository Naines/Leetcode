class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> res = new ArrayList<>();
        dfs(n,"", 0, 0 , res);
        return res;
    }

    void dfs(int n, String str, int o, int c, List<String> res){
        if(str.length()==2*n){
            res.add(str);
            return;
        }

        if(o<n) dfs(n, str+"(", o+1, c, res);
        if(c<o) dfs(n, str+")", o, c+1, res);
    }
}