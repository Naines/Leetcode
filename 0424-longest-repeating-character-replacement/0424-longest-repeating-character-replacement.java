class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l=0, ans=0, maxf=0;
        for(int r=0;r<s.length();r++){
            char ch= s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxf = Math.max(maxf, map.get(ch));

            while((r-l+1)-maxf >k){
                //resize
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
            }
            ans = Math.max(ans , r-l+1);
        }
        return ans;
    }
}