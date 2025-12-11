class Solution {
   public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        if(p.length()>s.length()) return indices;
        char chs[]=s.toCharArray(), chp[]=p.toCharArray();
        int pmap[]=new int[26];
        int smap[]=new int[26];
        for(char c:chp){
            pmap[c-'a']++;
        }

        for(int i=0;i<chp.length;i++){
            smap[chs[i]-'a']++;
        }
        if(check(pmap, smap)) indices.add(0);
        for(int i=chp.length;i<chs.length;i++){
            smap[chs[i]-'a']++;
            smap[chs[i-chp.length]-'a']--;
            if (check(smap, pmap))
            indices.add(i-chp.length+1);
        }
        return indices;
    }

    static boolean check(int chs[], int chp[]){
        for(int i=0;i<26;i++){
            if(chs[i]!=chp[i]) return false;
        }
        return true;
    }
}