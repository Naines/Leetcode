class Solution {
    public int countGoodNumbers(long n) {
        long n1 = n/2;
        long n2 = (n+1)/2;
        return (int)mul(pow(4, n1),pow(5,n2));
    }
    long pow(long x, long n){
        if(n==0) return 1;
        long half= pow(x, n/2);
        if(n%2==0) return mul(half,half);
        return mul(mul(half,half),x);
    }
    long mul(long a, long b){
        long m = 1000000007;
        return (a*b)%m;
    }
}