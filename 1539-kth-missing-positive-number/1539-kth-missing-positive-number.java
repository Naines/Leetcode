class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lb = 0, ub=arr.length-1;
        while(lb<=ub){
            int m = (lb+ub)/2;
            int missing  = arr[m]-(m+1);
            if(missing>=k){
                ub=m-1;
            }else{
                lb=m+1;
            }
        }

        return ub+k+1;
    }
}