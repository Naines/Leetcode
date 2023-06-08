/**
 * CountNegativeNumberInGrid1351
 */
public class CountNegativeNumberInGrid1351 {

    public int countNegatives(int[][] grid) {
        //binary search
        int h = grid.length, w = grid[0].length;
        int ans=0;
        for(int i=0;i<h;i++){
            int ub = w- upper(grid[i], 0, w,-1);
            ans+=ub;
        }
        return ans;
    }

     static int upper(int arr[], int lb, int ub, int key) {
        while (lb < ub) {
            int m = lb + (ub - lb) / 2;
            if (arr[m] > key) {
                lb = m + 1;
            } else {
                ub = m;
            }
        }
        return lb;
    }
}