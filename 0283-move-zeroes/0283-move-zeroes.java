class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;        
        int k = 0;
        for(int x: nums){
            if(x!=0){
                nums[k++]=x;
            }
        }
        for(int i=k;i<nums.length;i++){
            nums[i]=0;
        }
    }
}