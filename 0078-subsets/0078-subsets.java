class Solution {
    //1 2 3
    //inclusion exclusion
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        // dfs(nums,0, nums.length, new ArrayList<>());
        // return ans;


        int n= nums.length;
        for(int i=0;i<(1<<n);i++){
            List<Integer> curr = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    curr.add(nums[j]);
                }
            }
            ans.add(new ArrayList<>(curr));
        }
        return ans;
    }

    // void dfs(int nums[], int idx, int n, List<Integer> list){
    //     if(idx==n){
    //         ans.add(new ArrayList<>(list));
    //         return;
    //     }
    //     // System.out.println("IN AT"+idx+" "+list);
    //     list.add(nums[idx]);
    //     dfs(nums, idx+1, n, list);
    //     list.remove(list.size()-1);
    //     dfs(nums, idx+1, n, list);

    // }
}