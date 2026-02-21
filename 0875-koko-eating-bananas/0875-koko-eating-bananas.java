class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int x: piles) max=Math.max(max, x);

        int lb=1, ub=max;
        int ans =-1;
        while(lb<=ub){
            int m = lb+(ub-lb)/2; //current speed
            if(check(piles,m,h)){
                ans = m ;
                ub=m-1;
            }else{
                lb=m+1;
            }
        }
        return ans;
    } 
    boolean check(int arr[], int k, int h){
        int n=arr.length;
        int i=0;
        for(i=0;i<n;i++){
          int t= (arr[i]+k-1)/k;
          h-=t;
          if(h<0) break;
        }
        return i==n;
    }
}