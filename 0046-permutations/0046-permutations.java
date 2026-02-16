class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums);
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> curr, int nums[]){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(curr.contains(nums[i])) continue;
            curr.add(nums[i]);
            dfs(res, curr, nums);
            curr.remove(curr.size()-1);
        }
    }
}