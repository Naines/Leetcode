class Solution {
    public int maxScore(int[] arr, int k) {
        int l=0,n=arr.length;
        int S = 0;
        for(int x: arr) S+=x;

        int currSum=0, ans=0; k =n-k;
        for(int r=0;r<n;r++){
            currSum+=arr[r];
            System.out.println(r+" "+l+" "+currSum);
            if(r-l+1>k){
                currSum-=arr[l];
                l++;
            }
            System.out.println(currSum);
            if(r-l+1==k)ans = Math.max(ans, S-currSum);
        }
        return ans;
    }
}