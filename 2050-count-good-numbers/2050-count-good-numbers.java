class Solution {
    static int mod =  1000000007;
    static long mul(long a, long b) {
		return (a*b)%mod;
	}
    static long pow(int base, long e){
        if(e==0) return 1;
        long half = pow(base, e/2);
        if(e%2==0) return mul(half, half);
        else return mul(base, mul(half, half));
    }
    public int countGoodNumbers(long n) {

        long odd = n/2, even = (n+1)/2;
        long ans = mul(pow(4, odd),pow(5, even));
        return (int)ans;
    }
}