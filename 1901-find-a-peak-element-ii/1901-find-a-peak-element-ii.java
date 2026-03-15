class Solution {
    public int[] findPeakGrid(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, lb = 0, ub = m - 1;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            int max_row = 0;
            for (int i = 0; i < n; ++i) {
                if (matrix[max_row][mid] < matrix[i][mid])
                    max_row = i;
            }
            int left = mid-1>=0?matrix[max_row][mid-1]:-1;
            int right = mid+1<m?matrix[max_row][mid+1]:-1;
            if(matrix[max_row][mid]>left && matrix[max_row][mid]>right)
                return new int[]{max_row, mid};
            else if (matrix[max_row][mid]<left)
                ub = mid - 1;
            else
                lb = mid + 1;
        }
        return new int[] {-1, -1};
    }
}