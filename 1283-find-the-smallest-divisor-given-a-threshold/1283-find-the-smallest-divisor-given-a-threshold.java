class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        if(nums.length>threshold) return -1;
        int max= Integer.MIN_VALUE;
        for(int x: nums){
            max = Math.max(max,x);
        }
        int lb=1, ub=max, ans=-1;
        while(lb<=ub){
            int mid = lb + (ub-lb)/2;
            int count = check(nums, mid,threshold);
            //System.out.println(mid+" "+count);

            //0001111
            if(count<=threshold){
                ans = mid;
                ub= mid-1;
            }else{
                lb=mid+1;
            }
        }
        return ans;
    }

    int check(int nums[], int m, int t){
        int ans=0;
        for(int x: nums){
            int c = (x+m-1)/m;
            //System.out.println(c);
            ans+=c;
        }
        return ans;
    }
}