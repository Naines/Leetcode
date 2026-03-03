class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length, maxLis = 0, maxCount  =0 ;
        int lis[]=new int[n];
        int count[]=new int[n];
        for(int i=0;i<n;i++){
            lis[i] = 1;
            count[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                     //lis dont change for same length subsequence
                    if(lis[i]==lis[j]+1){
                        count[i]+=count[j];
                    }
                    if(lis[i]<=lis[j]){
                        lis[i]=lis[j]+1;
                        count[i]=count[j];
                    }

                   
                }
            }
           maxLis = Math.max(maxLis, lis[i]);
        }
        for (int i = 0; i < n; i++) {
            if (lis[i] == maxLis)
                maxCount += count[i];
        }

       return maxCount;
      
    }
    
}