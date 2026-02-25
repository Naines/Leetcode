class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // for(int x: nums) pq.add(x);
        // for(int i=0;i<k-1;i++)pq.poll();
        // return pq.peek();

        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // int i=0;
        // for(i=0;i<k;i++) pq.add(nums[i]);
        // for(;i<nums.length;i++) 
        //     if(nums[i]>pq.peek()) {
        //         pq.poll();
        //         pq.add(nums[i]);
        //     }
        // return pq.peek();

        int l =0 , r= nums.length-1;
        int n = nums.length;
        Random rand = new Random();
        while(true){
            int partIdx = partition( nums, l, r, l+rand.nextInt(r-l+1));
            if(partIdx==n-k) return nums[n-k];
            else if(partIdx>n-k) r = partIdx-1;
            else l = partIdx + 1;
        } 
    }

    int partition(int nums[], int l, int r, int rand){
        int pivot = nums[rand];
        swap(nums, rand, r);
        int i = l -1;
        for(int j=l; j<=r-1;j++){
            if(pivot> nums[j]){
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, r);
        return i+1;
    }
   



    void swap(int nums[], int l, int r){
        int temp = nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
}