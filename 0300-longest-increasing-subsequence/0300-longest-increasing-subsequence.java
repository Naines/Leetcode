class Solution {
    //10,9,2,5,3,7,101,18
    //1, 1,1,2,2,3, 4 , 4

    //1,3,6,7,9,4,10,5,6
    //1,2,3,
    public int lengthOfLIS(int[] nums) {
        // int n = nums.length,ans=0;
        // int lis[]=new int[n];
        // for(int i=0;i<n;i++){
        //     lis[i]=1;
        //     for(int j=0;j<i;j++){
        //         if(nums[j]<nums[i]){
        //             lis[i]=Math.max(lis[i], lis[j]+1);
        //         }  
        //     }
        //     ans=Math.max(ans, lis[i]);
        //     //System.out.print(lis[i]+"-"+nums[i]+"\n");
        // }
        // return ans;


        int n = nums.length;
        int tail[] = new int[n], len=0;
        for(int i=0;i<n;i++){
            if(len==0 || nums[i]>tail[len-1]){
                tail[len++] = nums[i];
                continue;
            }
            int idx = ceil(tail, 0, len, nums[i]);      
            tail[idx] = nums[i];
        }
        return len;
    }

    int ceil(int nums[], int l, int r, int k){
        while(l<r){
            int m = l + (r-l)/2;
            if(nums[m]>=k){
                 r = m;
            }   else {
                l=m+1;
            }
        }
        return r;
    }

    int ceil1(int tail[], int l, int r, int key){
        while(l<r){
            int m = l+(r-l)/2;
            if(tail[m]>=key) r=m;
            else l=m+1;
        }
        return r;
    }
}