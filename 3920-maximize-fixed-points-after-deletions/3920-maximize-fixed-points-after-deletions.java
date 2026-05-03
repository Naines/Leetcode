class Solution {

    //0,2,1 -> 0,1
    //y,n,n -> y,y

    /** 
    3 1 2 -> 1 2 
    n n n -> y y

    1012 -> nnnn
    012-> yyy
    delete 
    */
    public int maxFixedPoints(int[] nums) {
        int n = nums.length;
        int[][] rem = new int[n][2];
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (0 <= nums[i] && nums[i] <= i) {
                rem[m][0] = nums[i];
                rem[m][1] = i - nums[i];
                m++;
            }
        }

        Arrays.sort(rem, 0, m, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int[] lis = new int[m];
        int len = 0;
        for (int i = 0; i < m; i++) {
            int pos = lowerBound(lis, len, rem[i][0]);
            lis[pos] = rem[i][0];
            if (pos == len) {
                len++;
            }
        }
        return len;
    }

     private int lowerBound(int[] lis, int len, int target) {
        int left = 0;
        int right = len;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (lis[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}