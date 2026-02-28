class Solution {
    //6-110
    //1,2,3,4,5,6
    //11011110101110
    //num = num<<1+i

    //3 ,1,2,3
    //11011
    //10000 ~ 2^13
    //strlength ~ 130000
    
    //1 2 3
    //100 | 10 = 110
    //11000 | 11 = 11011

    long mod= ((int)1e9)+7;
    

    public int concatenatedBinary(int n) {
        long res = 0, countBits = 0;
        //o(Nlogn)
        for(int i=1;i<=n;i++){
            if((i&(i-1)) == 0) countBits++;;
            res = res<<countBits;
            res = res|i;
            res = res%mod;
        } 
       return (int)res;
    }
}