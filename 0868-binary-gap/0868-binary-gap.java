class Solution {
    public int binaryGap(int n) {
        int d=-1, ans=0;
        for(int i=0;i<32;i++){
           // System.out.println(i+" "+((n>>i)&1));
            if(((n>>i)&1) > 0){
                if(d>=0)
                    ans = Math.max(i-d, ans);
                d=i;
            }
        }
        return ans;
    }
}