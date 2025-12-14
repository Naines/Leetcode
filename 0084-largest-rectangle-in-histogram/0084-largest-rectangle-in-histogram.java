class Solution {

     public int largestRectangleArea(int[] arr) {
       int n = arr.length;
        int nse[] = new int[n];
        int pse[] = new int[n];
        Arrays.fill(nse, n);
        Arrays.fill(pse, -1);
        int max = 0;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] > arr[i]) {
                int t = stk.pop();
                nse[t] = i;
            }
            if (!stk.isEmpty())
                pse[i] = stk.peek();
            stk.push(i);
        }

        for (int i = 0; i < arr.length; i++) {
            int h = arr[i];
            int w = nse[i] - pse[i] - 1;
            max = Math.max(max, h * w);
        }

        return max;
    }
    // public int largestRectangleArea(int[] arr) {
    //     int n=arr.length;
    //     int maxArea=0, area=0;
    //     int i=0;
    //     Stack<Integer> stk=new Stack<>();
    //     while(i<n){
    //         if(stk.isEmpty() || arr[i]>= arr[stk.peek()])
    //         stk.push(i++);
    //         else{
    //             int top=stk.pop();
    //             area=stk.isEmpty()? arr[top]*i: arr[top]*(i-stk.peek()-1);
    //             maxArea=Math.max(area, maxArea);
    //         }
    //     }
    //     while(!stk.isEmpty())
    //     {
    //         int top=stk.pop();
    //             area=stk.isEmpty()? arr[top]*i: arr[top]*(i-stk.peek()-1);
    //             maxArea=Math.max(area, maxArea);
    //     }
    //     return maxArea;
    // }
}