class Solution {
    public int minDays(int[] days, int m, int k) {
        // Arrays.sort(days);
        int n= days.length;
        if(m*k>n) return -1;
        int lb=1, ub=1000000000;
        int ans =-1;
        while(lb<=ub){
            int mid = lb+(ub-lb)/2;
            if(make(days, mid, k)>=m){
                ans=mid;
                ub=mid-1;
            }else{
                lb=mid+1;
            }
        }
        return ans;
    }

    int make(int days[], int day, int k){
        int n=days.length;
        int bouq=0, flowers=0;
        for(int i=0;i<n;i++){
            if(days[i]<=day){
                flowers++;
                if(flowers==k){
                    bouq++;
                    flowers=0;
                }
            }else{
                flowers=0;
            }
        }
        return bouq;
    }
}