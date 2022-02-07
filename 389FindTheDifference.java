class Solution {
    public char findTheDifference(String s, String t) {
        int n = s.length();
        int hash[] = new int[26];
        for (char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            hash[ch - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] < 0)
                return (char) (i + 'a');
        }
        return '\n';
    }
}