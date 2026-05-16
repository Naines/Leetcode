class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int count[]=new int[n];
        int lis[]=new int[n];
        int maxLis=-1, ans=0;
        Arrays.fill(lis, 1);
        Arrays.fill(count, 1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){

                    if(1+lis[j]>lis[i]){
                        lis[i]=lis[j]+1;
                        count[i]=count[j];
                    }else if(lis[j]+1==lis[i]){
                        count[i]+=count[j];
                    }

                }          
            }
            if(maxLis==lis[i]) ans+=count[i];
            if(maxLis<lis[i]){
                maxLis=Math.max(maxLis, lis[i]);
                ans=count[i];
            }
        }
        return ans;

    }
}