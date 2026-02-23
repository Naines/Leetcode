class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> seen = new HashSet<>();
        for (int i = k; i <= s.length();i++) {
            if(seen.size()>=1<<k) break;
            seen.add(s.substring(i - k, i));
        }
        return seen.size() == 1 << k;
    }
}