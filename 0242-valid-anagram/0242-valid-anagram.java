class Solution {
    public boolean isAnagram(String s, String t) {
          int slen = s.length(), tlen = t.length();
        if (slen != tlen)
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < slen; i++) {
            char ch = s.charAt(i);
            char cht = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            map.put(cht, map.getOrDefault(cht, 0) - 1);
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() != 0)
                return false;
        }

        return true;
        

    }
}