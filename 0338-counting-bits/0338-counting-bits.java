class Solution {
    //count bits
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=count(i);
        }
        return ans;
    }
    //1010 
    //1001
    //1000 -> 8
    //0111
    int count(int n){
        int ans=0;
        while(n>0){
            n=n&n-1;
            ans++;
        }
        return ans;
    }
}