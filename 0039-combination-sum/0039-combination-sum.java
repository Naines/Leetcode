class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    int nums[];
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums=nums;
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
            curr.add(nums[i]);
            dfs(i, curr, t-nums[i]);
            curr.remove(curr.size()-1);
        }
    }
}