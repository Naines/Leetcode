class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                ans.add(map.get(target- nums[i])+1);
                ans.add(i+1);
            }
            map.put(nums[i], i);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
 
    }
}