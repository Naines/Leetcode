class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0,l=0,z=0,pre=0;
        for(int r=0;r<nums.length;r++){
            pre+=nums[r];
            while(l<r && (nums[l]==0 || pre>goal)){
                if(nums[l]==1) z=0;
                else z++;
                pre-=nums[l];
                l++;
            }
            if(pre==goal) ans+=z+1;
        }
        return ans;
    }

    //
    // public int numSubarraysWithSum(int[] nums, int goal) {
    //     int pre=0, ans =0;
    //     HashMap<Integer, Integer> map=new HashMap<>();
    //     map.put(0, 1);

    //     for(int r=0;r<nums.length;r++){
    //         pre+=nums[r];
    //         ans+=map.getOrDefault(pre-goal,0);
    //         map.put(pre, map.getOrDefault(pre, 0)+1);    
    //     }
        
    //     return ans;
    // }


    //M1: sliding window <=goal
    //rrrrr
    //l
    //00000 1+2+3+4+5

    //goal=2
    //rrrrr
    //..l
    //10101
    //.....
    //window=should have sum goal

    //ans = 1+1
    // public int numSubarraysWithSum(int[] nums, int goal) {
    //     System.out.println(countlessThanGoal(nums, goal));
    //     System.out.println(countlessThanGoal(nums, goal-1));

    //   return countlessThanGoal(nums, goal)-countlessThanGoal(nums, goal-1);
    // }

    // int countlessThanGoal(int nums[], int goal){
    //     if(goal<0) return 0;
    //     int l=0, ans = 0, sum=0;
    //     for(int r=0;r<nums.length;r++){
    //         sum+=nums[r];
    //         while(sum>goal){
    //             sum-=nums[l];
    //             l++;
    //         }
    //         ans+=r-l+1; //(all subarray ending at r)
    //     }
    //     return ans;
    // }
}