class Solution {
    //x^n
    //if(n<0) return 1/pow(x, n)
    //else if (n>0) return pow(x,n)
    //else return 1;
    double res = 1.0;
    public double myPow(double x, int n) {
        if(x==1) return 1.0d;
        if(n<0) return 1/pow(x, -n);
        else if(n>0) return pow(x, n);
        else return 1.0d;
    }

    //10^9~2^30
    //pow(2, 5) -> pow(2, 2)-> pow(2,1)
    double pow(double x,int n){
       if(n==0) return 1;
        double half = pow(x, n/2);
        if(n%2==0){
            return half*half;
        }
        return half*half*x;
    }
}