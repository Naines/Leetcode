class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int nums[];
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.nums=new int[]{1,2,3,4,5,6,7,8,9};
        dfs(k, n, 0, new ArrayList<>());
        return ans;
    }

    void dfs(int k, int t, int idx, List<Integer> curr){
        if(t<0 || k<0) return;
        if(k==0){
            if(t==0) ans.add(new ArrayList<>(curr));
            return;
        } 
        // System.out.println(i)
        for(int i=idx;i<nums.length;i++){
            curr.add(nums[i]);
            dfs(k-1, t-nums[i], i+1, curr);
            curr.remove(curr.size()-1);
        }
    }
}