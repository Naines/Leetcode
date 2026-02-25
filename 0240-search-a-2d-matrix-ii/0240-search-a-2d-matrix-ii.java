class Solution {
    public boolean searchMatrix(int[][] arr, int key) {
        int r=arr.length;
        int c=arr[0].length;
        if (r == 0 || c == 0)
            return false;
        int i=0, j=c-1;
        while(i<r && j>=0)
        {
            if(arr[i][j]==key)
            return true;
            else if(arr[i][j]>key)//search in same row
            j--;
            else //search in next row as arr[i][j]<key
            i++;
        }

        return false;
    }
}