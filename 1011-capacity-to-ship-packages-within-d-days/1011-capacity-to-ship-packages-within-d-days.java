class Solution {

    int isFeasible(int weights[], int W){
        int cur = 0, day=1;
        for (int w: weights) {
            if (cur + w > W) {
                day += 1;
                cur = 0;
            }
            cur += w;
        }
        return day;
    }

    public int shipWithinDays(int[] weights, int days) {
        int max = Arrays.stream(weights).max().orElseThrow();
        int lb=max, ub=(int)1e9,ans=-1;
        while(lb<=ub){
            int m = lb+(ub-lb)/2;
            int currday = isFeasible(weights, m);
            System.out.println(currday+" "+m);
            if(currday<=days){
                ans = m;
                ub = m-1;
            }else{
                lb=m+1;
            }
        }

        return ans;
    }
}