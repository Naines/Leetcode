class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int l=0, count =0, n=nums.length;
        int currSum = 0;
        
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        currSum=0;
        for(int r=0;r<n;r++){
            currSum+=nums[r];
            count+=map.getOrDefault(currSum-goal,0);
            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }
        return count;
    }
}