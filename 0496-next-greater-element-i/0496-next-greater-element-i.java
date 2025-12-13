class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums) {
        List<Integer> res =new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        Map<Integer, Integer> map =new HashMap<>();
        for(int i=nums.length-1;i>=0;i--){
            while (!stk.isEmpty() && stk.peek() <= nums[i])
                stk.pop();
            if(stk.isEmpty()) {
                  map.put(nums[i], -1);
            }
            else { 
                map.put(nums[i], stk.peek());
            }
            stk.push(nums[i]);
        }
        for(int x: nums1){
           res.add(map.get(x));
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}