class Solution {
    
    int count(int pages, int arr[], int students){
        //return num of students required to finish arr books
        int ans =1, currpg = 0;
        for(int p: arr){
            if(p+currpg <= pages){
                currpg+=p;
            }else{
                ans++;
                currpg=p;
            }
        }
        return ans;
    }
    public int splitArray(int[] nums, int k) {
         if (k > nums.length)
            return -1;

        // code here
        int lb= Arrays.stream(nums).max().getAsInt();
        int ub = Arrays.stream(nums).sum();
        
        int ans =-1;
        while(lb<=ub){
            int m = (lb+ub)/2;
            if(count(m, nums, k)<=k){
                ans = m;
                ub=m-1;
            }else{
                lb=m+1;
            }
        }
        return ans;
    }
}