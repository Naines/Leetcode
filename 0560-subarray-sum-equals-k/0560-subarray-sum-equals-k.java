class Solution {
    //1,1,1 ;2
    //1 2 3
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        int pre=0, ans =0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            pre+=nums[i];
            ans+=map.getOrDefault(pre-k,0);
            map.put(pre, map.getOrDefault(pre,0)+1);
        }
        return ans;
    }
}