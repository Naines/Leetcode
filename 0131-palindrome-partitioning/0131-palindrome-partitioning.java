class Solution {
    public List<List<String>> partition(String s) {
         List<List<String>> res = new ArrayList<>();
         dfs(res, new ArrayList<String>(), s);
         return res;
    }

    void dfs( List<List<String>> res, List<String> curr, String s){
        if(s.length()==0){
            res.add(new ArrayList<String>(curr));
            return;
        }
        for(int i=0;i<s.length();i++){
            String left=s.substring(0, i+1);
            if(isPalin(left)){
                curr.add(left);
                String right=s.substring(i+1);
                dfs(res, curr, right);
                curr.remove(curr.size()-1);
            }
        }
    }

    boolean isPalin(String str){
        int l=0, r=str.length()-1;
        while(l<r){
            if(str.charAt(l)==str.charAt(r)){
                l++;
                r--;
            }else return false;
        }
        return true;
    }
}