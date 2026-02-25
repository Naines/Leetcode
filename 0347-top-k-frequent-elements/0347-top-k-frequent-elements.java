class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x:  nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)-> b[1]-a[1]);
        for(Map.Entry<Integer, Integer> e :map.entrySet()){
            pq.add(new int[]{e.getKey(), e.getValue()});
        }

        int ans[]=new int[k];
        while(k>0){
            ans[k-1] = pq.poll()[0];
            k--; 
        }
        return ans;
    }
}