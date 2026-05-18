class Solution {

    //[a,b] : b->a
    public boolean canFinish(int n, int[][] pre) {
        int in[]=new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<pre.length;i++){
            graph.get(pre[i][1]).add(pre[i][0]);
            in[pre[i][0]]++;
        }
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
        return top.size()==n;
    }
}