class Solution {
    public int maxProduct(int[] arr) {
     int maxP = arr[0], minP= arr[0],ans = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<0){
                int temp = maxP;
                maxP= minP;
                minP = temp;
            }
            maxP = Math.max(maxP*arr[i], arr[i]);
            minP = Math.min(minP*arr[i], arr[i]);
            ans = Math.max(maxP, ans);
        }
        return ans;
    }


    /**
     public int maxProduct(int[] nums) {
       int pre=1, suff=1;
       int ans = Integer.MIN_VALUE;
       int n=nums.length;
       for(int i=0;i<nums.length;i++){
        if(pre == 0) pre=1;
        if(suff==0) suff=1;
        pre = pre*nums[i];
        suff = suff*nums[n-i-1];
        ans = Math.max(ans , Math.max(pre, suff));
       }
       return ans;
    } */
    /**
     public int maxProduct(int[] A) {
        int n = A.length, res = A[0], l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            l =  (l == 0 ? 1 : l) * A[i];
            r =  (r == 0 ? 1 : r) * A[n - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }
     */
}