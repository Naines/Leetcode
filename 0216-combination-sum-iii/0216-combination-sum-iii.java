class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(k, n, new ArrayList<>(), res, 1);
        return res;
    }

    void dfs(int k , int n, List<Integer> curr, List<List<Integer>> res, int start){
        if(n<0 || curr.size()>k) return;
        if(n==0 && curr.size()==k){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start;i<=9;i++){
            if(i>n) break;
            curr.add(i);
            dfs(k, n-i,curr, res, i+1);
            curr.remove(curr.size()-1);
        }
    }
}