public class Monoqueue{
    Deque<Integer> q = new ArrayDeque<>();

    public void push(Integer n){

        while(!q.isEmpty() && q.peekLast().compareTo(n) <0) q.pollLast();
        q.offerLast(n);
    }
    public Integer front(){
        return q.peekFirst();
    }

    public void pop(Integer n){
        if (n.equals(q.peekFirst())) q.pollFirst();
    }

}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return new int[0];
		}
        Monoqueue mq = new Monoqueue();
        int [] res = new int[nums.length-k+1];
        int idx = 0;
        for (int i = 0; i< nums.length;i++){
            if (i<k-1) mq.push(nums[i]);
            else{
                mq.push(nums[i]);
                res[idx++] = mq.front();
                mq.pop(nums[i-k+1]);
            }
        }
        return res;
    }
}