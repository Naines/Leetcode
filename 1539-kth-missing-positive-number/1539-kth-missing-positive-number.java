class Solution {
    //2,3,4,7,11
    /**
    2 3 4 7 11 12
    arr[i]-(i+1)
    1 1 1 3  6  6
    
     */
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

        return lb+k;


        //O(n) solution
        // Set<Integer> set= new HashSet<>();
        // for(int x: arr) set.add(x);
        // int i=1;
        // int n=k+arr.length+1;
        // for(;i<=n;i++){
        //     if(!set.contains(i)) k--;
        //     if(k==0) break;
        // }
        // return k==0?i:-1;
    }
}