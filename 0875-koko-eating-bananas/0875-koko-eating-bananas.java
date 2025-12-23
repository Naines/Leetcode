class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n= piles.length;
        Arrays.sort(piles);
        int lb=1, ub=(int)1e9;
        int ans = -1;
        while(lb<=ub){
            int mid = lb + (ub-lb)/2;
            long tt=0;
            for(int i=0;i<n;i++){
                tt+= (piles[i]+mid-1)/mid;
            }
            if(tt>h){
                lb = mid+1;
            }else{
                ub = mid-1;
                ans=mid;
            }
        } 
        return ans;
    }


    //BRUTE FORCE 
    // public int minEatingSpeed(int[] piles, int h) {
    //     int k=1, n= piles.length;
    //     Arrays.sort(piles);
    //     while(true){
    //         int tt=0;
    //         for(int i=0;i<n;i++){
    //             tt+=(piles[i]+k-1)/k;
    //         }
    //         if(tt<=h) return k;
    //         k++;
    //     }
    // }
}