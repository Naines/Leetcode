class Solution {
    public List<List<Integer>> combinationSum(int[] a, int t) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(a, t, new ArrayList<Integer>(), 0, res);
        return res;
    }

    void dfs(int a[], int trgt, List<Integer> curr, int idx, List<List<Integer>> res){
        if(trgt<0) return;
        if(trgt==0){
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i=idx;i<a.length;i++){
            curr.add(a[i]);
            dfs(a, trgt-a[i],curr, i, res);
            curr.remove(curr.size()-1);
        }
    }
}