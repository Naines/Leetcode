class Solution {
    //max(abs(3 sum)
    //-1,2, 
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        double ans = nums[0]+nums[1]+nums[2];
        // int arr[][]=new int[][];
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int l = i+1, r= n-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                // 1, 3
                if(Math.abs(target-sum)< Math.abs(ans-target)){
                    ans = sum;
                }

                if(sum<target) l++;
                else r--;
            }
               
                // for(int k = j+1; k<n;k++){
                //     int sum = nums[i]+nums[j]+nums[k];
                //     System.out.println(sum);
                //     if(Math.abs(sum-target)<ans){
                //         System.out.println(nums[i]+" "+nums[j]+" "+nums[k]);
                //         ans = nums[i]+nums[j]+nums[k];
                //     }
                // }
        }
        return (int)ans;
    }
}