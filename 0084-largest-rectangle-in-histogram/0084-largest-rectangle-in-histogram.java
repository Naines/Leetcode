class Solution {

    //max Stack
    //2,4,1
    //stk: 2,
    //left=1, right:stk.peek() = 2
    //right-left-1
    //pse:
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk=new Stack<>();
        int n=heights.length;
        int ans=0, area=0;
        int nse[]=new int[n];
        int pse[]=new int[n];
        Arrays.fill(nse, n);
        Arrays.fill(pse, -1);
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && heights[stk.peek()]>heights[i]){
                int t = stk.pop();
                nse[t]= i;
            }
            if(!stk.isEmpty()) pse[i]=stk.peek();
            stk.push(i);
        }
        for(int i=0;i<n;i++){
            int w = nse[i]-pse[i]-1;
            ans=Math.max(ans, heights[i]*w);
        }
        return ans;

    }
}