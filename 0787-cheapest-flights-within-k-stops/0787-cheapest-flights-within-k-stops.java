class Solution {
    //k stops means k+1 edges can be used
    //use bellman ford k+1 times instead of n times/relax edges k times
    //transverse all edges
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax edges up to k+1 times
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(dist, n);
            for (int[] f : flights) {
                int u = f[0], v = f[1], w = f[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < temp[v]) {
                    temp[v] = dist[u] + w;
                }
            }
            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}