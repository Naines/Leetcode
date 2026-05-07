class Solution {
    //1 2 3
    //inclusion exclusion
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0, nums.length, new ArrayList<>());
        return ans;
    }

    void dfs(int nums[], int idx, int n, List<Integer> list){
        if(idx==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        // System.out.println("IN AT"+idx+" "+list);
        list.add(nums[idx]);
        dfs(nums, idx+1, n, list);
        list.remove(list.size()-1);
        dfs(nums, idx+1, n, list);

    }
}