class Solution {
    public int trap(int[] height) {
        Stack<Integer> stk=new Stack<>();
        int n=height.length, count=0;
        // int nge[]=new int[n];
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && height[stk.peek()]<height[i]){
                int t=stk.pop();
                if(!stk.isEmpty()){
                    int h = Math.min(height[stk.peek()], height[i]) - height[t];
                    int w = i-stk.peek()-1;
                    // System.out.println(h+" "+w);
                    count+=(h*w);
                }
            }
            stk.push(i);
        }
        return count;
    }
}