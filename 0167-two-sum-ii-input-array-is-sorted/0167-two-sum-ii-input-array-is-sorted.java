class Solution {

    public int[] twoSum(int[] nums, int target) {
        int left =0, right = nums.length-1;
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum==target) return new int[]{left+1, right+1};
            if(sum>target) right--;
            else left++;
        }
        return new int[]{-1,-1};
    }

    //HASHMAP - not optimized - n
    //BS dont use -nlogn
    //use 2 pointers 
    // public int[] twoSum(int[] nums, int target) {

        //NOT OPTIMIZED, use BS to find the target instead of using Map\
        //Map has complexity of O(n), in case of collision
        // List<Integer> ans = new ArrayList<>();
        // Map<Integer, Integer> map=new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     if(map.containsKey(target-nums[i])){
        //         ans.add(map.get(target- nums[i])+1);
        //         ans.add(i+1);
        //     }
        //     map.put(nums[i], i);
        // }
        // return ans.stream().mapToInt(Integer::intValue).toArray();
        
    //     List<Integer> ans = new ArrayList<>();
    //     for(int i=0;i<nums.length;i++){
    //         if(bs(nums, target-nums[i],i+1)!=-1 && bs(nums, target-nums[i],i+1)!=i){
    //             ans.add(i+1);
    //             ans.add(bs(nums, target-nums[i],i+1)+1);
    //             break;
    //         }
    //     }
    //     return ans.stream().mapToInt(Integer::intValue).toArray();
       
    // }
    // //bs optimize to not use first occurence
    //  int bs(int nums[], int key, int lb){
    //         int ub=nums.length-1;
    //         while(lb<=ub){
    //             int mid = lb + (ub-lb)/2;
    //             if(nums[mid]==key) return mid;
    //             else if(nums[mid]>key) ub=mid-1;
    //             else lb=mid+1;
    //         }
    //         return -1;
    //     }
}