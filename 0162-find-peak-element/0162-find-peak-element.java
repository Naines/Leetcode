class Solution {
    public int findPeakElement(int[] arr) {
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            boolean leftExists = (i==0 || arr[i-1]<=arr[i]);
            boolean rightExists = (i==n-1|| arr[i+1]<=arr[i]);
            if(leftExists && rightExists) return i;
        }
        return -1;
    }
}