class Solution {
    //either copy paste index by index
    //or minus the curr by any other from array
    //e-e = e
    //o-e = o
    //o-o = e
    //e- o = o

    //if all are even or odd, just copy.
    // 2 4 324 21 1 213 31
    // 1 3 323 20 1 212 30

    // 3 4 323 21 213 31
    // 3 1   

    // minimum number be odd else false

    public boolean uniformArray(int[] nums1) {
        boolean alleven = true;
        int min = nums1[0];
        for(int x: nums1){
            min = Math.min(min, x);
            if(x%2!=0) alleven = false;
        }
        // if(min%2!=0) return true;
        if(min%2==0){
            if(alleven) return true;
            else return false;
        }
        return true;
    }
}