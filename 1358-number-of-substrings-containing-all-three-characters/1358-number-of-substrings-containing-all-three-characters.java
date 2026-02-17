class Solution {
    public int numberOfSubstrings(String s) {
        int map[]=new int[3];
        int l=0, count=0;
        for(int r=0;r<s.length();r++){
            map[s.charAt(r)-'a']++;
            while(map[0]>0 && map[1]>0 && map[2]>0){
                count+=s.length()-r;
                map[s.charAt(l)-'a']--;
                l++;
            }
        }
        return count;
    }
}