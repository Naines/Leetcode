class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums) {
        List<Integer> ans =new ArrayList<>();
        List<Integer> res =new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while (!stk.isEmpty() && stk.peek() <= nums[i])
                stk.pop();
            if(stk.isEmpty()) {
                ans.add(-1);
            }
            else { 
                ans.add(stk.peek());
            }
            stk.push(nums[i]);
        }
        Collections.reverse(ans);
        // for(int x: ans) System.out.println(x);
        Map<Integer, Integer> map =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], ans.get(i));
        }
        for(int x: nums1){
           res.add(map.get(x));
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}