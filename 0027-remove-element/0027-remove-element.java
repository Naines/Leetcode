class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int l=0, r=0;
        for(r=0;r<n;r++){
            if(nums[r]!=val){
                nums[l]=nums[r];
                l++;
            }
        }
        return l;
    }
}