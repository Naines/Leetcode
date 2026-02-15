class Solution {
    public double myPow(double x, int n) {
        if(n<0) {
            double res =  1/solve(x, n*-1);
            return res;
        }
        else return solve(x, n);
    }

    static double solve(double x, int n){
        if(n==0) return 1;
        double half = solve(x, n/2);
        if(n%2==0) return half*half;
        return half*half*x;
    }
    
}