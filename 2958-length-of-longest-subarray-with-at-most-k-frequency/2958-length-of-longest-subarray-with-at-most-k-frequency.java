class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l=0, ans =0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int r=0;r<nums.length;r++){
            //1,2,3,1,2,3,1,2
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);
            //resize
            while(map.get(nums[r])>k){
                map.put(nums[l], map.get(nums[l])-1);
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}