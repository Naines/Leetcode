class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      return findTripletsHashMap(nums);
    }

    static List<List<Integer>> findTripletsHashMap(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n - 1; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int find = 0 - (arr[i] + arr[j]);
                if (map.containsKey(find)) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(arr[i]);
                    ans.add(arr[j]);
                    ans.add(find);
                    Collections.sort(ans);
                    set.add(ans);
                }
                map.put(arr[j], j);
            }
        }
        res.addAll(set);
        return res;
    }

}