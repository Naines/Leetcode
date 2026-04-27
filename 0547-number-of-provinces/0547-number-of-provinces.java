class Solution {

    static class DSU{
        int parent[], n;
        int count=0;
        DSU(int n){
            this.n=n;
            parent=new int[n+1];
            for(int i=0;i<=n;i++)
            parent[i]=i;
        }


        // 1 2 3 4 5
        // 1 2 3 4 5 
        // 1 2 3 1 1
        int find(int a){
            if(parent[a]!=a){
                parent[a]=find(parent[a]);
            }
            return parent[a];
        }

        //union(1,4) -> union(4,5) -> 
        void union(int a, int b){
            int pa=find(a), pb=find(b);
            if(pa!=pb){
                parent[pb]=pa;
                count++;
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count =0;
        int n=isConnected.length;
        DSU dsu=new DSU(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    dsu.union(i, j);
                }
            }
        }
        return n-dsu.count;
    }
}