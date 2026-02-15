class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        helper(0, nums, res, new ArrayList<Integer>());
        return new ArrayList<>(res);
    }

    void helper(int idx, int nums[], Set<List<Integer>> res, List<Integer> curr){
        if(idx==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[idx]);
        helper(idx+1, nums, res, curr);
        curr.remove(curr.size()-1);
        helper(idx+1, nums, res, curr);
    }
}