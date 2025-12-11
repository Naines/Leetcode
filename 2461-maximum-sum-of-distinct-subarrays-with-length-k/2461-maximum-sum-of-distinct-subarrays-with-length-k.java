class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        //iterate over the windows slide,
        //check the max sum in all windows
        //maintain map for distinct
        long sum=0, ans=0;
        int l=0;
        Set<Integer> elements = new HashSet<>();
      
        for(int r=0;r<nums.length;r++){

            if(!elements.contains(nums[r])){
                sum+=nums[r];
                elements.add(nums[r]);

                if(r-l+1 == k){
                    //window found, calculate
                    ans = Math.max(ans, sum);
                    sum-=nums[l];
                    elements.remove(nums[l++]);
                }
            }else{
                //slide till last, as window needs to be deleted
                while(nums[l]!=nums[r]){
                    sum-=nums[l];
                    elements.remove(nums[l++]);
                }
                l++;
            }
        }
       
        return ans;
    }
}