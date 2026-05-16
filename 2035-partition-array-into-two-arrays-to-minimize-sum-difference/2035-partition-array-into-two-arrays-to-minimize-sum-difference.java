class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        // create left half
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = nums[i];
        }
        // create right half
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            right[i] = nums[i + n];
        }
        List<List<Integer>> leftSums = generate(left);
        List<List<Integer>> rightSums = generate(right);
        // sort right side sums
        for (List<Integer> list : rightSums) {
            Collections.sort(list);
        }
        int ans = Integer.MAX_VALUE;
        for (int leftCount = 0; leftCount <= n; leftCount++) {
            List<Integer> leftList = leftSums.get(leftCount);
            List<Integer> rightList = rightSums.get(n - leftCount);
            for (int leftSum : leftList) {
                int target = totalSum / 2 - leftSum;
                int idx = Collections.binarySearch(
                        rightList,
                        target
                );
                if (idx < 0) {
                    idx = -idx - 1;
                }
                // check idx
                if (idx < rightList.size()) {
                    int s1 = leftSum + rightList.get(idx);
                    int s2 = totalSum - s1;
                    int diff = Math.abs(s1 - s2);
                    ans = Math.min(ans, diff);
                }
                // check idx - 1
                if (idx- 1 >=0) {
                    int s1 = leftSum + rightList.get(idx - 1);
                    int s2 = totalSum - s1;
                    int diff = Math.abs(s1 - s2);
                    ans = Math.min(ans, diff);
                }
            }
        }
        return ans;
    }

    private List<List<Integer>> generate(int[] arr) {

        int n = arr.length;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            result.add(new ArrayList<>());
        }

        int totalMasks = 1 << n;

        for (int mask = 0; mask < totalMasks; mask++) {

            int count = 0;
            int sum = 0;

            for (int i = 0; i < n; i++) {

                boolean bitSet = (mask & (1 << i)) != 0;

                if (bitSet) {
                    count++;
                    sum += arr[i];
                }
            }

            result.get(count).add(sum);
        }

        return result;
    }
}