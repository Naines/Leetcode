class Solution {
    public boolean isAnagram(String s, String t) {
        int slen = s.length(), tlen = t.length();
        if (slen != tlen)
            return false;

        int map[]=new int[26];
        for(int i=0;i<slen;i++){
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(map[i]!=0) return false;
        }

        return true;
        

    }
}