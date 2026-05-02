class NumArray {

    int nums[], sums[];
    public NumArray(int[] nums) {
        this.nums=nums;
        sums=new int[nums.length];
        sums[0]=nums[0];
        for(int i=1;i<sums.length;i++){
            sums[i]=sums[i-1]+nums[i];
        }
    }
    
    //1 2 3 4 5 6
    //1 3 6 10 15 21
    //(1,2) -> 6-3
    public int sumRange(int left, int right) {
        return left!=0?sums[right]-sums[left-1]:sums[right];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */