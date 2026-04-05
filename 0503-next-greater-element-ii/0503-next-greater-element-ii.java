class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n =nums.length;
        int arr[]=new int[n*2];
        for(int i=0;i<n;i++) arr[i]=nums[i];
        for(int i=n;i<2*n;i++) arr[i]=nums[i-n];

        Stack<Integer> stk=new Stack<>();
        int nge[]=new int[2*n];
        Arrays.fill(nge, -1);
        for(int i=0;i<2*n;i++){
            
            //1,1
            //nge:-1,
            while(!stk.isEmpty() && arr[stk.peek()]<arr[i]){
                int t=stk.pop();
                nge[t] = arr[i];
            }
            stk.push(i);
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++)
        ans[i]=nge[i];
        return ans;

    }
}