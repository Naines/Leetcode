class Solution {
     public static List<Integer> largestDivisibleSubset(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        int lis[] = new int[n];
        int pre[] = new int[n];

        Arrays.fill(lis, 1);
        Arrays.fill(pre, -1);
        int max = -1, index = 0;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    if (lis[i] <= lis[j]) {
                        lis[i] = lis[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (max < lis[i]) {
                max = lis[i];
                index = i;
            }
        }
        

        while (index != -1) {
            list.add(0,nums[index]);
            index = pre[index];
        }
        return list;
    }

}