public class EqualSumSubsets {
    static boolean canPartition(int nums[], int k) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % k == 0)
            return solve(nums, k, sum / k, 0, sum, new boolean[nums.length], 0);
        return false;
    }

    static boolean solve(int nums[], int k, int target, int curr, int sum, boolean vis[], int idx) {
        if (k == 1)
            return true;

        if (curr == target) {
            return solve(nums, k - 1, target, 0, sum, vis, 0);
        }
        for (int i = idx; i < nums.length; i++) {
            if (vis[i])
                continue;
            vis[i] = true;
            if (solve(nums, k, target, curr + nums[i], sum, vis, i + 1))
                return true;
            // backtrack
            vis[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 3, 2, 3, 5, 2, 1 }, k = 4;
        System.out.println(canPartition(nums, k));
    }
}
