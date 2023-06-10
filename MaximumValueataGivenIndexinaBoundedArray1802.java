public class MaximumValueataGivenIndexinaBoundedArray {
    public long getSum(int index, int sum, int n) {
        long ans = 0;
        // for left
        // sum-ind......sum
        // 1,1,1,1,2,3,....sum
        if (sum > index) {
            ans += (long) (sum + sum - index) * (index + 1) / 2;
        } else {
            ans += (long) (sum + 1) * (sum) / 2 + index - sum + 1;
        }
        // for right
        // sum, sum-1,......sum-(n-index-1)
        // sum, sum-1, sum-2,....2,1,1,1,1
        if (sum > n - index) {
            ans += (long) (sum + sum - n + 1 + index) * (n - index) / 2;
        } else {
            ans += (long) (sum + 1) * sum / 2 + n - index - sum;
        }
        return ans - sum;
    }

    public int maxValue(int n, int index, int maxSum) {
        int lb = 1, ub = maxSum;
        while (lb < ub) {
            int m = (lb + ub + 1) / 2;
            if (getSum(index, m, n) <= maxSum) {
                lb = m; // possible ans but find better
            } else {
                ub = m - 1;
            }
        }
        return lb;
    }

}
