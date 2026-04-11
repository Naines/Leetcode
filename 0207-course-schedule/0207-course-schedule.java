class Solution {

    //[a,b]
    //b->a
    boolean vis[], in[];
    public boolean canFinish(int n, int[][] arr) {
        this.vis=new boolean[n];
        this.in=new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][1]).add(arr[i][0]);
        }
        
        for(int i=0;i<n;i++){
            if(vis[i]) continue;
            if(dfs(adj, n, i)) return false;
        }
        return true;
    }

    boolean dfs(List<List<Integer>> adj, int n, int u){
        vis[u]=true;
        in[u]=true;
        // System.out.println("in at"+u);
        // System.out.println(Arrays.toString(vis));
        // System.out.println(Arrays.toString(in));
        for(int v: adj.get(u)){
            if(!vis[v]){
                if(dfs(adj, n, v)) 
                    return true;
            }else if(in[v]){
                return true;
            }
        }
        in[u]=false;
        return false;
    }

}