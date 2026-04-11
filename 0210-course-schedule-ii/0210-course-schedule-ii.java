class Solution {

    //get in degree and do Toposort
    public int[] findOrder(int n, int[][] arr) {
        List<List<Integer>> adj  =new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int in[] = new int[n];
        // vis = new boolean[n];
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        //1,0
        //0->1
        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][1]).add(arr[i][0]);
        }
        for(int u=0;u<n;u++){
            for(int v: adj.get(u)){
                in[v]++;
            }
        }
        for(int i=0;i<n;i++) if(in[i]==0) q.add(i);
        while(!q.isEmpty()){
            int t = q.poll();
            ans.add(t);
            for(int u: adj.get(t)){
                in[u]--;
                if(in[u]==0) 
                    q.add(u);
            }
        }
        if(ans.size()!=n) return new int[]{};
        return ans.stream().mapToInt(Integer::intValue).toArray();
    
    }
}