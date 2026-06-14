class Solution {
    int nums[];
    int count=0;
    Map<String, Integer> map = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
       this.nums = nums;
        dfs(target, 0);
        return map.get(target+"-"+0);
    }

    int dfs(int target, int idx){
        String key = target+"-"+idx;
        if(map.containsKey(key)) return map.get(key);

        if(idx==nums.length){
            map.put(key, target==0?1:0);           
            return map.get(key);
        }


        int ways = dfs(target+nums[idx], idx+1)+
        dfs(target-nums[idx], idx+1);
        map.put(key, ways);
        return ways;
    }
}