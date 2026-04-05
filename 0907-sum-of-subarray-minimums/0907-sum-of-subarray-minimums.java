class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n =arr.length;
        long sum=0;
        int m=(int)1e9+7;
        int j,k;
        int dp[]=new int[n+1];
        Stack<Integer> stk=new Stack<>();
        stk.push(-1);
        for(int i=0;i<arr.length;i++){
            while(stk.peek()!=-1 && arr[stk.peek()]>=arr[i]){
                int t = stk.pop();
            }
            dp[i+1] = (dp[stk.peek()+1] + (i-stk.peek()) *arr[i]) %m;
            stk.push(i);
            sum+=dp[i+1];
            sum%=m;
        }
        return (int)sum;
    }
}