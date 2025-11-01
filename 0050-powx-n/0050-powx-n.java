class Solution {
    public double myPow(double x, int n) {
       
       if(n==0) return 1;
       if(n<0) return 1/x * myPow(1/x, -(n + 1));
       double half= myPow(x*x, n/2);
        return n%2==0? half : x*half;
    }

	

}