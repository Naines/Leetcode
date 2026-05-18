class Solution {
    //[1,0][1,2][0,1]
    //0=1  
    //2-1
    public int[] findOrder(int n, int[][] pre) {
        int in[]=new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<pre.length;i++){
            // System.out.println(pre[i][1]+" "+pre[i][0]);
            graph.get(pre[i][1]).add(pre[i][0]);
            in[pre[i][0]]++;
        }
        // for(int i=0;i<n;i++) System.out.println(graph.get(i));
        // System.out.println(Arrays.toString(in));
        for(int i=0;i<n;i++) if(in[i]==0) q.add(i);

        List<Integer> top=new ArrayList<>();
        //count==top.size()
        while(!q.isEmpty()){
            int t=q.poll();
            top.add(t);
            for(int v: graph.get(t)){
                in[v]--;
                if(in[v]==0) q.add(v);
            }
        }
        return top.size()==n?top.stream().mapToInt(Integer::intValue).toArray():new int[0];
    }
}