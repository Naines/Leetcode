class Solution {
    public int reverse(int x) {
        int ans =0;
        while(x!=0){
            int d = x%10;
            int n = ans*10 + d;
            if((n-d)/10!=ans) return 0;
            ans = n;
            x=x/10;
        }
        return ans;
    }
}