class Solution {

    //[1,0] ,, 0->1
    public int[] findOrder(int n, int[][] p) {
        int in[]=new int[n];
        boolean vis[]=new boolean[n];
        List<List<Integer>> adj=new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<Integer>());
        for(int i=0;i<p.length;i++){
            adj.get(p[i][0]).add(p[i][1]);
            in[p[i][1]]++;
        }
        // for(int i=0;i<n;i++) System.out.println(i+":"+adj.get(i));
        // for(int i=0;i<n;i++) System.out.println(in[i]);

        for(int i=0;i<n;i++) if(in[i]==0) q.add(i);
        while(!q.isEmpty()){
            int u=q.poll();
            ans.add(u);
            for(int v:adj.get(u)){
                // System.out.println(u+":"+v);
                in[v]--;
                if(in[v]==0) q.add(v);
            }
        }
        if(ans.size()!=n) return new int[]{};
        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
        
    }
}