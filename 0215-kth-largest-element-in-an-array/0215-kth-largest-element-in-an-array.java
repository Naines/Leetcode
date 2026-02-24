class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // for(int x: nums) pq.add(x);
        // for(int i=0;i<k-1;i++)pq.poll();
        // return pq.peek();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        for(i=0;i<k;i++) pq.add(nums[i]);
        for(;i<nums.length;i++) 
            if(nums[i]>pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        return pq.peek();
    }
}