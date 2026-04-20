class Solution {
    //1,8,3,8,3
    //123456789
    //0.4....3.

    //1,1,1,6,1,1,1
    //123456789
    //6....3...

    public int maxDistance(int[] colors) {
        int n=colors.length;
        int c0=colors[0], cN=colors[n-1];
        int lMax=0, rMax=0;
        for(int i=0; i<n; i++){
            int c=colors[i];
            if (c0!=c && i>lMax) lMax=i;
            if (cN!=c && n-1-i>rMax) rMax=n-1-i;
        }
        return Math.max(lMax, rMax);
    }
}