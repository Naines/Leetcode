class Solution {
    public int findPeakElement(int[] arr) {
        // int n=arr.length;
        // for(int i=0;i<arr.length;i++){
        //     boolean leftExists = (i==0 || arr[i-1]<=arr[i]);
        //     boolean rightExists = (i==n-1|| arr[i+1]<=arr[i]);
        //     if(leftExists && rightExists) return i;
        // }
        // return -1;
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] < arr[mid+1]){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }

        return start;
    }
}