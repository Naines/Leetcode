class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m =nums1.length, n=nums2.length;
        int i=0,j=0,k=0;
        int arr[]=new int[m+n];
        while(i<m && j<n){
           // System.out.println(i+" "+nums1[i]+"-"+j+" "+nums2[j]);
            if(nums1[i]<nums2[j]){
                arr[k++]=nums1[i++];
            } else{
                arr[k++]=nums2[j++];
            }
        }
        while(i<m) arr[k++]=nums1[i++];
        while(j<n) arr[k++]=nums2[j++];

        double median = 0.0;
        return k%2==0? (arr[k/2]+arr[(k-1)/2])/2.0:arr[k/2];

    }
}