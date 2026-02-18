class Solution {
    public int singleNonDuplicate(int[] nums) {
         int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] == nums[mid ^ 1])
                lo = mid + 1; //ans is right part
            else
                hi = mid;
        }
        return nums[lo];
    }
}