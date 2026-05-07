class Solution {
    /**
        minimize the W cap
        1 2 3 4 5 6 7 8 9 10, d=5
        1.....1+2+3..10

    
     */

    public int shipWithinDays(int[] a, int d) {
        // Arrays.sort(a);
        int min = a[0], max=0;
        for(int x:a) {
            min=Math.max(min, x);
            max+=x;
        }
        int ans=(int)1e9;
        int lb=min, ub=max;
        while(lb<=ub){
            int m=lb+(ub-lb)/2;
            int ship = find(a, m);
            if(ship<=d){
                ans=m;
                ub=m-1;
            }else{
                lb=m+1;
            }
        }
        return ans;
    }
    // public int shipWithinDays(int[] a, int d) {
    //     // Arrays.sort(a);
    //     int min = a[0], max=0;
    //     for(int x:a) {
    //         min=Math.max(min, x);
    //         max+=x;
    //     }
    //     int ans=(int)1e9;
    //     for(int W=min;W<max;W++){
    //         int ship = find(a, W);
    //         System.out.println(ship+" "+W);
    //         if(ship<=d) ans=Math.min(W, ans);
    //     }
    //     return ans;
    // }

    //number of days to ship weights[] with W max per day
    int find(int a[], int W){
        int ans=1;
        // int i=0;
        int w=W;

        //100000, 100000, 100000, w=1
        for(int i=0;i<a.length;){
            if(a[i]<=w){
                w-=a[i];
                i++;
            }else{
                w=W;
                ans++;
                // System.out.println(W+" "+ans+" "+a[i]);
            }
        }
        return ans;
    }
}