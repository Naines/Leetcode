class Solution {

    //reverse toposort
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int in[]=new int[n];
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            for(int x: graph[i]){
                adj.get(x).add(i);
            }
        }
        for(int u=0;u<n;u++){
            for(int v: adj.get(u)){
                in[v]++;
            }
        }
        for(int i=0;i<n;i++) if(in[i]==0) q.add(i);
        while(!q.isEmpty()){
            int t=q.poll();
            ans.add(t);
            for(int v: adj.get(t)){
                in[v]--;
                if(in[v]==0) q.add(v);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}