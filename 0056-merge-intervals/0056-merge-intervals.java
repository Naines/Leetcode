class Solution {
    public int[][] merge(int[][] arr) {
        int n = arr.length;
        Pair pairs[] = new Pair[n];
        List<Pair> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);
        for (Pair p : pairs) {
            if (ans.isEmpty() || ans.get(ans.size() - 1).y < p.x) {
                ans.add(new Pair(p.x, p.y));
            } else {
                ans.get(ans.size() - 1).y = Math.max(ans.get(ans.size() - 1).y, p.y);
            }
        }
        return ans.stream().map(x -> new int[]{x.x, x.y}).toArray(int[][]::new);
    }
    static class Pair implements Comparable<Pair>{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair o) {
            return this.x-o.x;
        }
    }
}