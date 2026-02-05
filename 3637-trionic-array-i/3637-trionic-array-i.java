class Solution {
    public boolean isTrionic(int[] nums) {
        if(nums.length<=3) return false;
        int ans = 0;
        for(int i=2;i<nums.length;i++){
            if(i==2 && nums[i-1]<=nums[i-2]) return false;
            if(nums[i-1]==nums[i] || nums[i-2]==nums[i-1]) return false;
            int d1 = nums[i-1]>nums[i-2]?1:0;
            int d2 = nums[i]>nums[i-1]?1:0;
            System.out.print(nums[i-2]+" "+nums[i-1]+" "+nums[i]+" "+(d1^d2));
            System.out.println();
            ans+=(d1^d2);
        }
        return ans==2;
    }
}