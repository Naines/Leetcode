class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lb=0,ub=arr.length-1;
        while(lb<ub){
            int mid=(lb+ub)/2;
            //increasing slope, go right
           if(arr[mid]<arr[mid+1])
               lb=mid+1;
            else ub=mid;
        }
        return lb;
    }
}