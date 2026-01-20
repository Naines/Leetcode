class Solution {
static int dp[]=new int[256];
    public int hammingWeight(int n) {
        init();
        return dp[n&0xff]+dp[(n>>8)&0xff]+dp[(n>>16)&0xff]+dp[(n>>24)&0xff];
    }
    static void init(){
        dp[0]=0;
        for(int i=1;i<=255;i++){
            dp[i] = dp[i>>1]+(i&1);
        }
    }
}