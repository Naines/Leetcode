class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(),new int[nums.length], nums);
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> curr,int vis[], int nums[]){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(vis[i]==1) continue;
            if(i>0 && nums[i-1]==nums[i] && vis[i-1]==0) continue;
            vis[i]=1;
            curr.add(nums[i]);
            dfs(res, curr,vis, nums);
            vis[i]=0;
            curr.remove(curr.size()-1);
        }
    }
}