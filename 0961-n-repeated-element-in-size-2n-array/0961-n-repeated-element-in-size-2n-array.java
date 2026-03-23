class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length/2;
        int map[]=new int[10001];
        for(int i=0;i<nums.length;i++){
            map[nums[i]]++;
        }
        for(int i=0;i<nums.length;i++){
            if(map[nums[i]]==n) return nums[i];
        }
        return -1;
    }
}