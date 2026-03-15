class Solution {

    //12 23 34
    //13
    
    //sort by end time
    //find count of non-overlapping intervals
    //return total - count
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int prev = 0;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (intervals[prev][1]<=intervals[i][0]) {
                prev = i;
                count++;
            }
        }
        return n - count;
    }
}