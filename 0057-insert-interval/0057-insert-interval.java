class Solution {
    /**
    case1: add to start
    case2: add to mid -> add all intervals with e<ni[0] to list
    ni[0]<=e, merge
    case 3: add to end
     */
    public int[][] insert(int[][] intervals, int[] ni) {
        List<int[]> list=new ArrayList<>();
        int i=0, n=intervals.length;
        while(i<n && intervals[i][1]<ni[0]){
            list.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0] <= ni[1]){
            ni[0]=Math.min(ni[0], intervals[i][0]);
            ni[1]=Math.max(ni[1], intervals[i][1]);
            i++;
        }
        list.add(ni);
        while(i<n){
            list.add(intervals[i++]);
        }
        int res[][]=new int[list.size()][2];
        for(int x=0;x<list.size();x++){
            res[x][0]=list.get(x)[0];
            res[x][1]=list.get(x)[1];
        }
        return res;
    }
}