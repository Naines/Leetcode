class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m+n;
        int ans[]=new int[l];
        int i1=0, i2=0,k=0;
        while(i1<m && i2<n){
            if(nums1[i1]<=nums2[i2]){
                ans[k++]=nums1[i1++];
            }else{
                ans[k++]=nums2[i2++];
            }
        }
        while(i1<m) ans[k++]=nums1[i1++];
        while(i2<n) ans[k++]=nums2[i2++];
        for(int i=0;i<l;i++){
            nums1[i]=ans[i];
        }
    }
}