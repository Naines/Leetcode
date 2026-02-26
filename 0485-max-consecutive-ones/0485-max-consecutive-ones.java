class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans =0;
        int count=0;
        for(int x: nums){
            if(x==1){
                count++;
                ans =Math.max(ans, count);
            }else{
                count=0;
            }
        }
        return ans;
    }
}