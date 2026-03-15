class Solution {

    //2, 7, 11, 15
    //Arrays.sort
    //18
    //2, 16 ->l++ , nums[r]>target
    //2, 7 

    //-5, -4, -3, -4, -5
    //-8


    public int[] twoSum(int[] nums, int target) {
        int arr[][]=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            arr[i] = new int[]{nums[i], i};
        }
        Arrays.sort(arr, (a, b)-> (a[0]-b[0]));
        //for(int x[]: arr) System.out.println(Arrays.toString(x));
        int l =0, r=nums.length-1;

        while(l<r){
            int x = arr[l][0]; //-19
            if(arr[r][0]==target-x){
                return new int[]{arr[l][1], arr[r][1]};
            }else if(arr[r][0]>target-x){
                r--;
            }else{
                l++;
            }
        }
        return new int[]{-1,-1};
    }
    // static class Pair implements Comparable<Pair>{
    //     int n, i;
    //     Pair(int n, int i){
    //         this.n=n;
    //         this.i=i;
    //     }
    //     public int compareTo(Pair)
    // }
}