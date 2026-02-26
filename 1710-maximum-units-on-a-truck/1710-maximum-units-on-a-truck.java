class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b)->b[1]-a[1]);
        int i=0, ans =0, n = boxTypes.length;
        while(truckSize>0 && i<n){
            int t = Math.min(boxTypes[i][0], truckSize);
            truckSize-=t;
            ans+=t*boxTypes[i][1];
            i++;
        }
        return ans;
    }
}