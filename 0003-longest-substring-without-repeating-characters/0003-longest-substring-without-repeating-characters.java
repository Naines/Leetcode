class Solution {
    //pwwkew
    //l
    //rrr
    public int lengthOfLongestSubstring(String s) {
        int l=0, ans=0;
        Map<Character, Integer> map=new HashMap<>();
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0)+1);

            while(map.get(ch)>1){
                char chl =s.charAt(l);
                int c=map.get(chl);
                if(c>1) map.put(chl, c-1);
                else map.remove(chl);
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}