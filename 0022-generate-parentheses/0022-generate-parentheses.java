class Solution {
    public List<String> generateParenthesis(int n) {
        //keep track of number of left and right
        //if(left<n) add (
        //if(right<left) add )
        List<String> ans = new ArrayList<>();
        dfs(n,0,0,"",ans);
        return ans;
    }

    void dfs(int n, int left,int right, String str, List<String> ans){
        if(str.length()==2*n){
            //print result and return
            ans.add(str);
            return;
        }

        if(left<n) dfs(n,left+1, right, str+"(", ans);
        if(right<left) dfs(n, left, right+1, str+")", ans);
    }
}