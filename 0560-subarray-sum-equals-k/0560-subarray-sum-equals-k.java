class Solution {
    
    /**
    public int subarraySum(int[] nums, int k) {
        if(nums.length==0) return 0;
        return find(nums, k, 0);
    }
    int find(int nums[], int k, int j){
        if(j>=nums.length)  return 0;
        int res=0, sum=0;
        
        for(int i=j;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k){
                res++;
            }
        }
        return res+find(nums, k, j+1);
    }*/

    //if sum till index i = x
    //if till index a = x-k
    //x-k arrays from arr til idx i, to get the count
    public int subarraySum(int nums[], int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int n =nums.length, ans =0, sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int remove = sum - k;
            if(map.containsKey(remove))
                ans+= map.get(remove);
            map.put(sum, map.getOrDefault(sum, 0) +1);
        }  
        return ans;
    }
    
}