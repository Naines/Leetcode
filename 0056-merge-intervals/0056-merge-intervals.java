class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals, (a, b)-> (a[0]-b[0]));
        for(int x[]: intervals){
            //next start > prev end
            if(ans.size()==0 || x[0]>ans.get(ans.size()-1)[1]){
                ans.add(new int[]{x[0], x[1]});
            }else{
                int t[] = ans.get(ans.size()-1);
                ans.remove(ans.size()-1);
                int a = Math.min(t[0],x[0]);
                int b = Math.max(t[1], x[1]);
                ans.add(new int[]{a, b});
            }
            //System.out.println(ans);
        }
        int size = ans.size();
        int mat[][]=new int[size][2];
        for(int i=0;i<size;i++){
            mat[i][0] =ans.get(i)[0];
            mat[i][1]=ans.get(i)[1];
        }
        return mat;
    }
}