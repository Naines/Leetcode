class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int lb=1;
        int ub = Arrays.stream(piles).max().getAsInt();
        int ans =0;
        //System.out.println(lb+" "+ub);
        while(lb<=ub){
            int m = lb + (ub-lb)/2;
            long hours = 0;
            for(int i=0;i<piles.length;i++){
                hours+= (piles[i]+m-1)/m;
            }
            //1,2,3,.....11
            //5
            if(hours<=h){
                ans = m;
                ub=m-1; 
            }else{
                lb=m+1;
            }
        }   
        return ans;
    }
    
}