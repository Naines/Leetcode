class Solution {
    // 3 6 7 11 , h=8
    // per hour speed  = (pile[i]+k-1)/k
    //search space: min(piles), max(piles)
    public int minEatingSpeed(int[] piles, int h) {
        int min=1, max=piles[0];
        for(int x: piles){
            min = Math.min(min, x);
            max= Math.max(max, x);
        }

        int lb=min, ub=max;
        int ans=0;
        while(lb<=ub){
            int m = lb+(ub-lb)/2;
            // System.out.println(m+" "+lb+" "+ub);
            long reqd=canDo(piles, m);
            // System.out.println("found: "+m+" "+reqd);
            if(reqd<=h){
                ans=m;
                ub=m-1;
            }else{
                lb=m+1;
            }
        }
        return ans;
    }

    //find hours taken to clear piles at rate m per hour
    long canDo(int piles[], int m){
        long ans=0;
        for(int i=0;i<piles.length;i++){
            long hrs = (piles[i]+m-1)/m;
            ans+=hrs;
        }
        return ans;
    }
}