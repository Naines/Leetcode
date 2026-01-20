class Solution {
    static int dp[]=new int[256];
    public int[] countBits(int n) {
        init();
        
        int ans[] = new int[n+1];
        ans[0]=0;
        for(int i=1;i<=n;i++){
            ans[i] = dp[i&0xff]+dp[(i>>8)&0xff]+dp[(i>>16)&0xff];
        }
        return ans;
    }
    void init(){
        dp[0]=0;
        for(int i=1;i<=255;i++){
            dp[i] = dp[i>>1]+(i&1);
        }
    }
}
