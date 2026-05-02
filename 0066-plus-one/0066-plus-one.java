class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;

        //[]
        if(n==0){
            return new int[]{1};
        }

        //[general case]
        //[4213123]
        if(digits[n-1]<9) {
            digits[n-1]+=1;
            return digits;
        }

        //[3249999], [9999], [1999]
        //till we get carry over,
        // [9,9,9] + 1 = [0,0,0]
        int t=n-1;
        while(t>=0 && digits[t]==9){
            t--;
        }

        if(t<0){
            digits=new int[n+1];
            digits[0]=1;
        }else{
            digits[t]+=1;
            for(int i=t+1;i<n;i++) digits[i]=0;
        }
        return digits;
        //case: i<0,  
        //case: i==0,
        //case: i>0 -> 
    }
}