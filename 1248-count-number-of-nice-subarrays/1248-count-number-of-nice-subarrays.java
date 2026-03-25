class Solution {
    //rrrrrr
    //211211,3

    //21121
    //1121
    //1211

    //if(count==k) ans++;
    public int numberOfSubarrays(int[] nums, int k) {
        int pre=0, n=nums.length, ans=0;
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0) pre++;
            ans+=map.getOrDefault(pre-k,0);
            map.put(pre, map.getOrDefault(pre,0)+1);
        }
        return ans;
    }
}