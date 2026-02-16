class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, target, res, new ArrayList<>());
        return res;
    }

    void dfs(int nums[], int idx, int target, List<List<Integer>> res, List<Integer> curr){
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx;i<nums.length;i++){
            if (i > idx && nums[i] == nums[i - 1]) continue;
            if (nums[i] > target) break;
            curr.add(nums[i]);
            dfs(nums, i+1, target-nums[i], res, curr);
            curr.remove(curr.size()-1);
        }
    }
}