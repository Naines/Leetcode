class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int in[]=new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
                in[i]++;
            }
        }

        // for(int i=0;i<n;i++) System.out.println(adj.get(i));
        // System.out.println(Arrays.toString(in));
        for(int i=0;i<n;i++) if(in[i]==0) q.add(i);

        List<Integer> top=new ArrayList<>();
        
        while(!q.isEmpty()){
            int t=q.poll();
            top.add(t);
            for(int v: adj.get(t)){
                in[v]--;
                if(in[v]==0) q.add(v);
            }
        }
        Collections.sort(top);
        return top;
    }
}