class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if(i<k-1){
                //complete initial window-1 size
                //q.push(nums[i]); //push maintaining order
                while(!q.isEmpty() && nums[i]>q.peekLast()) q.pollLast();
                q.addLast(nums[i]);
            }else{
                // pq.push(nums[i]);
                while(!q.isEmpty() && nums[i]>q.peekLast()) q.pollLast();
                q.addLast(nums[i]);

                //
                ans.add(q.peekFirst());

                //remove left window ptr
                if(q.peekFirst()==nums[i-k+1]) q.poll();
            }
        }
        return ans.stream().mapToInt(i->i).toArray();
    }


}

// public class Monoqueue{
//     Deque<Integer> q = new ArrayDeque<>();

//     public void push(Integer n){
//         while(!q.isEmpty() && q.peekLast().compareTo(n) <0) q.pollLast();
//         q.offerLast(n);
//     }
//     public Integer front(){
//         return q.peekFirst();
//     }

//     public void pop(Integer n){
//         if (n.equals(q.peekFirst())) q.pollFirst();
//     }

// }

// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
// 		if (nums == null || k <= 0) {
// 			return new int[0];
// 		}
//         Monoqueue mq = new Monoqueue();
//         int [] res = new int[nums.length-k+1];
//         int idx = 0;
//         for (int i = 0; i< nums.length;i++){
//             if (i<k-1) mq.push(nums[i]);
//             else{
//                 mq.push(nums[i]);
//                 res[idx++] = mq.front();
//                 mq.pop(nums[i-k+1]);
//             }
//         }
//         return res;
//     }
// }