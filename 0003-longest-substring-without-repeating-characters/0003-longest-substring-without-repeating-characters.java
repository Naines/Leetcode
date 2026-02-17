class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0, ans=0;
        int map[]=new int[256];
        Arrays.fill(map,-1);
        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            // System.out.println(ch+": "+l+" "+r+" "+map[ch]);
            if(map[ch]>=l)
                l=map[ch]+1;
            map[ch]=r;
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}