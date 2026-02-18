class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> curr, int idx, int n, int k){
        if(k==0){
            res.add(new ArrayList<Integer>(curr));
            return;
        }

        for(int i=idx;i<=n;i++){
            curr.add(i);
            dfs(res, curr, i+1,n,k-1);
            curr.remove(curr.size()-1);
        }
    }
}