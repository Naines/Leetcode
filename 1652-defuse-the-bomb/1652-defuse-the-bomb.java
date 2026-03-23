class Solution {

    //5,7,1,4
    //12,10,16,13

    //2,4,9,3
    //12,4,6,13       
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=1;j<=(int)Math.abs(k);j++){
                sum+=code[nextIndex(k, i,j,n)];
                // System.out.println(code[i]+" "+sum+" "+nextIndex(k,i, j,n));
            }
            ans[i]=sum;
        }
        return ans;
    }

    int nextIndex(int k, int i,int j, int len){
        if(k<0){
            return (i-j+len)%len;
        }else if(k>0){
            return (i+j+len)%len;
        }
        return 0;
    }
}