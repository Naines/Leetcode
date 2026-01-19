class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int count[]=new int[1000002];
        int max = -1;
        for(int x[]: intervals){
            count[x[0]]++;
            count[x[1]+1]--;
        }
        int res = 0;
        for(int c: count){
            res+=c;
            max = Math.max(max, res);
        }
        return max;
    }
}