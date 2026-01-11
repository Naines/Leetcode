class Solution {
    public int maximalRectangle(char[][] matrix) {
        int h = matrix.length, w = matrix[0].length;
        int arr[]=new int[w];
        int ans =0;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(matrix[i][j]=='0')
                    arr[j] = 0;
                else 
                    arr[j] = arr[j] + matrix[i][j]-'0'; 
            }
            int area = largestRectangleArea(arr);
            ans = Math.max(ans, area);
        }
        return ans;
    }
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
}