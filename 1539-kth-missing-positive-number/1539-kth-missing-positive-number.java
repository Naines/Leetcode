class Solution {
    //2,3,4,7,11
    //
    public int findKthPositive(int[] arr, int k) {
        // int lb = 0, ub=arr.length-1;
        // while(lb<=ub){
        //     int m = (lb+ub)/2;
        //     int missing  = arr[m]-(m+1);
        //     if(missing>=k){
        //         ub=m-1;
        //     }else{
        //         lb=m+1;
        //     }
        // }

        // return lb+k;
        Set<Integer> set= new HashSet<>();
        for(int x: arr) set.add(x);
                // System.out.println(k+arr.length+1+" "+k);
        int i=1;
        int n=k+arr.length+1;
        for(;i<=n;i++){
            if(!set.contains(i)) k--;
            // System.out.println(i+" "+k);
            if(k==0) break;
        }
        // System.out.println(i+" "+k);

        return k==0?i:-1;
    }

    //2,3,4,7,11
    //1,5,6,8,9
}