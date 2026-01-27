class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int map[]=new int[26];
        for(int i=0;i<order.length();i++){
            map[order.charAt(i)-'a'] = i;

        }
        for(int i=1;i<words.length;i++){
            if(compare(words[i-1], words[i], map) > 0 ) return false;
        }
        return true;
    }

    int compare(String  a, String b, int dict[]){
        int l1=a.length(), l2=b.length();
        int min = Math.min(l1, l2);
        for(int i=0;i< min;i++){
            int c1 = a.charAt(i)-'a', c2=b.charAt(i)-'a';
            if(c1!=c2)
                return dict[c1] - dict[c2];
        }
        return l1==min?-1:1;
    }
}