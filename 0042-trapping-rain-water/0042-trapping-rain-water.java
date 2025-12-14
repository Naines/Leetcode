class Solution {
    public int trap(int[] arr) {
          Stack<Integer> stk = new Stack<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] < arr[i]) {
                int t = stk.pop();
                if (!stk.isEmpty()) {
                    int h = Math.min(arr[i], arr[stk.peek()]) - arr[t];
                    int w = i - stk.peek() - 1;
                    count += h * w;
                    // System.out.println(i+" "+arr[t]+" "+t+ " " + count);
                    // System.out.println("height = "+h+" weight="+w);
                    // System.out.println("count = "+(w*h));
                }
            }
            stk.push(i);
            // System.out.println(arr[i]+" pushed");
        }
        return count;
    }
}