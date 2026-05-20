class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[] = new int[n];
        int pre=1, suff=1;
        Arrays.fill(ans, 1);
        for(int i=0;i<n;i++){
            ans[i]*=pre;
            ans[n-i-1]*=suff;
            pre*=nums[i];
            suff*=nums[n-i-1];
        }

        return ans;

    }
}