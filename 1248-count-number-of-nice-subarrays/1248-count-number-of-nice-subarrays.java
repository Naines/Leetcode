class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        int l=0,n=nums.length, nodd=0;
        int count=0;
        for(int r=0;r<n;r++){
            if((nums[r]&1)==1) nodd++;
            count+=map.getOrDefault(nodd-k,0);
            map.put(nodd, map.getOrDefault(nodd,0)+1);
        }
        return count;
    }
}