class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, 0,0, new StringBuilder());
        return ans;
    }

    void dfs(int n , int open, int close, StringBuilder sb){
        if(sb.length()==n*2){
            ans.add(sb.toString());
            return;
        }

        // System.out.println(ans);
        
        //((( <n
        if(open<n){
            dfs(n, open+1, close, sb.append("("));
            sb.deleteCharAt(sb.length()-1);
        }

        //close<open
        //()))) not allowed
        //((() can be done
        if(open>close){
            dfs(n, open, close+1, sb.append(")"));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}