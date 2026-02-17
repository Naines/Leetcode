class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums, k)-atmost(nums, k-1);
    }

    int atmost(int nums[], int k){
        int l=0, n=nums.length, ans=0;
        Map<Integer, Integer> map=new HashMap<>();
        for(int r=0;r<n;r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            while(map.size()>k){
                //resize
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l])==0) map.remove(nums[l]);
                l++;
            }
            ans+=r-l+1;
        }
        return ans;
    }
}