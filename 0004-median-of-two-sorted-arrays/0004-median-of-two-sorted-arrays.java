class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Binary Search to find the 2 partitions
        int n1=nums1.length, n2=nums2.length;
        int total = n1+n2;
        if(total%2==1){
            int center =  kthEle((total+1)/2, nums1, nums2);
            System.out.println("center="+center);
            return center;
        }else{
            int left =  kthEle(total/2, nums1,nums2);
            //System.out.println("left="+left);
            int right = kthEle(total/2+1, nums1, nums2);
             //System.out.println("right="+right);
            return (left+right)/2.0;
        }
        // return 0.0;
        
        //2 pointer
        // int m =nums1.length, n=nums2.length;
        // int i=0,j=0,k=0;
        // int arr[]=new int[m+n];
        // while(i<m && j<n){
        //    // System.out.println(i+" "+nums1[i]+"-"+j+" "+nums2[j]);
        //     if(nums1[i]<nums2[j]){
        //         arr[k++]=nums1[i++];
        //     } else{
        //         arr[k++]=nums2[j++];
        //     }
        // }
        // while(i<m) arr[k++]=nums1[i++];
        // while(j<n) arr[k++]=nums2[j++];

        // double median = 0.0;
        // return k%2==0? (arr[k/2]+arr[(k-1)/2])/2.0:arr[k/2];
    }

    //returns kth Ele in union of n1 and n2
    int kthEle(int k, int nums1[], int nums2[]){
        int min1 = 1000000, min2=1000000, max1=0, max2=0;
        if(nums1.length!=0){
            min1=nums1[0];
            max1=nums1[nums1.length-1];
        }
        if(nums2.length!=0){
            min2=nums2[0];
             max2=nums2[nums2.length-1];
        }

        int lb = Math.min(min1, min2);
        int ub= Math.max(max1, max2);
        int ans =ub;
        while(lb<=ub){
            int m = lb+(ub-lb)/2;
            int count = count(m ,  nums1, nums2);
            //System.out.println(m+" "+count+" "+k);
            if(count(m,  nums1, nums2)>=k){
                ans = m;
                //System.out.println("Answer updated to "+ans);

                ub = m-1;
            }else{
                lb=m+1;
            }
        }
        return ans;
    }

    //count of numbers in nums1 and nums2 > k
    int count(int k, int nums1[], int nums2[]){
        int count =0;
        count+=upperBound(nums1, k);
        count+=upperBound(nums2, k);
        return count;
    }

    //pos where nums[x]>=k 
    static int upperBound(int nums[], int k) {
        int lb = 0, ub = nums.length;
        while (lb < ub) {
            int m = (lb + ub) / 2;
            if (nums[m] <= k) {
               lb=m+1;
            } else {
                ub = m;
            }
        }
        return ub;
    }
}