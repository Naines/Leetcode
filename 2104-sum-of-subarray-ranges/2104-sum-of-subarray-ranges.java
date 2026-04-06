class Solution {
    public long subArrayRanges(int[] nums) {
        int n =nums.length;
        long res=0;
        for(int i=0;i<n;i++){
            int min=nums[i], max=nums[i];
            //i...j
            //1..4
            //2..4
            //3..4
            //4..4
            for(int j=i;j<n;j++){
                min=Math.min(min, nums[j]);
                max=Math.max(max, nums[j]);
                res+=max-min;
            }
        }
        return res;
    }
}