class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk=new Stack<>();
        Map<Integer, Integer> map=new HashMap<>();
        int nge[]=new int[nums2.length], ans[]=new int[nums1.length];
        Arrays.fill(nge, -1);

        for(int i=0;i<nums2.length;i++){
            while(!stk.isEmpty() && nums2[stk.peek()]<nums2[i]){
                int t=stk.pop();
                nge[t]=nums2[i];
            }
            stk.push(i);
            map.put(nums2[i], i);
        }

        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                ans[i]=nge[map.get(nums1[i])];
            }
        }
        return ans;
    }
}