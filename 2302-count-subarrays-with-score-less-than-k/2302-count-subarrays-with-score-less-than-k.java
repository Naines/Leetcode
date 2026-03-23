class Solution {
    //score<k
    //a>0
    //   l....r -> score<k
    // count[]
     public long countSubarrays(int[] arr, long k) {
        int n = arr.length,l=0;
        long ans = 0;
        long sum = 0;
        for (int r = 0; r < n; r++) {
            sum+=arr[r];
            while(!isValid(r-l+1, sum, k)){
                sum-=arr[l];
                l++;
            }
            ans+=r-l+1;
        }
        return ans;
    }
    boolean isValid(int len, long sum, long k){
        long mul = len*sum;
        return mul<k;
    }
    // public int countSubarrays(int[] arr, long k) {
    //     int n = arr.length;
    //     int ans = 0;

    //     for (int i = 0; i < n; i++) {
    //         int sum = 0;
    //         for (int j = i; j < n; j++) {
    //             sum += arr[j];
    //             int length = j - i + 1;
    //             long score = (long) sum * length;
    //             if (score < k) {
    //                 //System.out.println(score+" "+j+" "+i);
    //                 ans++;
    //             }
    //         }
    //     }
    //     return ans;
    // }
}