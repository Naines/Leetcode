class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Map<Integer, Integer>> mem = new HashMap<>();
        return process(nums, target, 0, mem);
    }

    private int process(int[] arr, int target, int i, Map<Integer, Map<Integer, Integer>> mem) {
        if (i == arr.length) {
            if (target == 0) return 1;
            return 0;
        }
        if (mem.containsKey(i) && mem.get(i).containsKey(target)) {
            return mem.get(i).get(target);
        }
        int res1 = process(arr, target - arr[i], i + 1, mem);
        int res2 = process(arr, target + arr[i], i + 1, mem);
        int res = res1 + res2;
        mem.computeIfAbsent(i, k -> new HashMap<>()).put(target, res);
        return res;
    }
}