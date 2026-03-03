class Solution {
    public int longestMountain(int[] arr) {
        int n =arr.length;
        int lis[]=new int[n];
        int lds[]=new int[n];

        Arrays.fill(lis,1);
        Arrays.fill(lds, 1);
        for(int i=1;i<n;i++){
            // for(int j=0;j<i;j++){
                if(arr[i-1]<arr[i]){
                    // if(lis[i]<=lis[]){
                        lis[i]=lis[i-1]+1;
                    }
            //     }
            // }
        }

         for(int i=n-2;i>=0;i--){
            // for(int j=n-1;j>i;j--){
                if(arr[i]>arr[i+1]){
                    // if(lds[i]<=lds[j]){
                        lds[i]=lds[i+1]+1;
                    // }
                }
            // }
        }

        System.out.println(Arrays.toString(lis));
        System.out.println(Arrays.toString(lds));
        int ans =0;
        for(int i=0;i<n;i++){
           if(lis[i]>1 && lds[i]>1){
            ans = Math.max(lis[i]+ lds[i]-1, ans);
           }
        }
        return ans;
    }
}