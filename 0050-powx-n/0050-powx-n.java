class Solution {
    public double myPow(double x, int n) {
       if(n==0) return 1;
       //reduce n by 1 before converting to positibe, to fix overflow
       // case: n = -2^31
       if(n<0) return 1/x * myPow(1/x, -(n + 1));
       double half= myPow(x*x, n/2);
        return n%2==0? half : x*half;
    }

	

}