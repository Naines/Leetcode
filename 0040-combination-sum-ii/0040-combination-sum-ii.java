class Solution { 
    List<List<Integer>> ans=new ArrayList<>();
    int nums[];
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        this.nums=nums;
        Arrays.sort(nums);
        dfs(0, new ArrayList<>(), target);
        return ans;
    }
    void dfs(int idx, List<Integer> curr, int t){
        if(t<0) return;
        if(t==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            dfs(i+1, curr, t-nums[i]);
            curr.remove(curr.size()-1);
        }
    }
}