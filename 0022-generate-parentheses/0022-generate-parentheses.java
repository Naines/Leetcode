class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> res = new ArrayList<>();
        dfs(n,new StringBuilder(), 0, 0 , res);
        return res;
    }

    void dfs(int n, StringBuilder str, int o, int c, List<String> res){
        if(str.toString().length()==2*n){
            res.add(str.toString());
            return;
        }

        if(o<n) {dfs(n, str.append("("), o+1, c, res);
         str.deleteCharAt(str.length() - 1);
        }
        if(c<o) {
            dfs(n, str.append(")"), o, c+1, res);
         str.deleteCharAt(str.length() - 1);
        }
    }
}