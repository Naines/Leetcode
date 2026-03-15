class Solution {
    public int[][] insert(int[][] arr, int[] b) {
        List<int[]> result = new ArrayList<>();
        int i=0;
        
        // add all the intervals ending before newInterval starts
        while(i<arr.length && arr[i][1]< b[0]){
            result.add(arr[i]);
            i++;
        }

        // merge all overlapping intervals to one considering newInterval
        while(i<arr.length && arr[i][0]<=b[1]){
            b[0] = Math.min(b[0], arr[i][0]);
            b[1]= Math.max(b[1], arr[i][1]);
            i++;
        }

        result.add(b);

        while(i<arr.length){
            result.add(arr[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);

    }
}