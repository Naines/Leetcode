class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        int ans = 0;
        for(int n : set) {
            // confirm n is start
            if(!set.contains(n - 1)) {  
                int m = n + 1;
                while(set.contains(m)) {
                    m++;
                }
                ans = Math.max(ans, m - n);
            }
        }
        return ans;
    }
}