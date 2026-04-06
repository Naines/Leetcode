class Solution {
    int m=(int)1e9+7;
    public int sumSubarrayMins(int[] arr) {
        int n =arr.length;
        long sum=0;
       
        Stack<Integer> stk=new Stack<>();
        int nse[]=new int[n];
        int pse[]=new int[n];
        Arrays.fill(nse, -1);
        Arrays.fill(pse, -1);
        for(int i=0;i<arr.length;i++){
            while(!stk.isEmpty() && arr[stk.peek()]>=arr[i]){
                int t = stk.pop();
                nse[t]=i;
            }
            if(!stk.isEmpty()){
                pse[i]= stk.peek();
            }
            stk.push(i);
        }
        for(int i=0;i<n;i++){
            int ld = pse[i]==-1?i+1:(i-pse[i]);
            int rd = nse[i]==-1?n-i:(nse[i]-i);
            // System.out.println(arr[i]+" "+ld+" "+rd);
            sum = add(sum , mul(arr[i], mul(ld, rd)) );
        }
        return (int)sum;
    }

    long add(long a, long b){
        return (a+b)%m;
    }
    long mul(long a, long b) {
        return (a*b)%m;
    }
}