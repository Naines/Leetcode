class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                //search for l, r idxes in latter half fixing i, j
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int l = j+1, r = n-1;
                long required = (long)target-nums[i]-nums[j];
                while(l<r){
                    long sum  = nums[l]+nums[r];
                    if(sum==required){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;r--;
                        while (l < r && nums[l] == nums[l - 1])
                            l++;
                        while (l < r && nums[r] == nums[r + 1])
                            r--;
                    }else if(sum> required){
                        r--;
                    }else{
                        l++;
                    }
                }
            }
        }
        return ans;
    }
}