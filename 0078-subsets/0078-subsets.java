class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<(1<<n);i++){
            List<Integer> curr = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    curr.add(nums[j]);
                }
            }
            list.add(new ArrayList<>(curr));
        }
        return list;
    }
}