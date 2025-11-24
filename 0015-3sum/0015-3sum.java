class Solution {

    //Approach 1: brute force
    //Approach 2: hashmap O(n^2*logn), space: O(n)
    //Appraoch 3L sorting + 2 pointers
    public List<List<Integer>> threeSum(int[] nums) {
    //   return findTripletsHashMap(nums);
        return approach3(nums);
    }

    //const = i
    //left = i+1, right = n-1

    static List<List<Integer>> approach3(int nums[]){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        //i: 0-> n-2
        //j/left: i+1 -> n-1
        //k/right: n-1 -> left
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1, right =n-1;
            int trgt = -nums[i];

            while(left<right){
                int sum = nums[left] + nums[right];
                if(sum==trgt){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--;
                    left++;
                      while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                }else if(sum<trgt){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }


    //Approach 2
    // static List<List<Integer>> findTripletsHashMap(int[] arr) {

    //     List<List<Integer>> res = new ArrayList<>();
    //     int n = arr.length;
    //     Set<List<Integer>> set = new HashSet<>();

    //     for (int i = 0; i < n - 1; i++) {
    //         Map<Integer, Integer> map = new HashMap<>();
    //         for (int j = i + 1; j < n; j++) {
    //             int find = 0 - (arr[i] + arr[j]);
    //             if (map.containsKey(find)) {
    //                 List<Integer> ans = new ArrayList<>();
    //                 ans.add(arr[i]);
    //                 ans.add(arr[j]);
    //                 ans.add(find);
    //                 Collections.sort(ans);
    //                 set.add(ans);
    //             }
    //             map.put(arr[j], j);
    //         }
    //     }
    //     res.addAll(set);
    //     return res;
    // }

}