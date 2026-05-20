class Solution {
    public int firstMissingPositive(int[] nums) {
        //1. map the numbers and then transverse first missing
        // 2 transversal
        
        int n = nums.length;
        boolean seen[] = new boolean[n+1];
        for(int num: nums){
            if(num>0 && num<=n)
                seen[num] = true;
        }
        for(int i=1;i<=n;i++)
            if(!seen[i]) return i;
        
        return n+1;
    }
}