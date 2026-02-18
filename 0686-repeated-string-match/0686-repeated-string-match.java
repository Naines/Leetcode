class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        int ans =1;
        while(sb.length()<b.length()){
           sb.append(a);
           ans++;
        }
        if(substr(b,sb.toString())) return ans;
        sb.append(a);
        if(substr(b,sb.toString())) return ans+1;
        return -1;
    }

    public static boolean substr(String a, String b) {
         int m = a.length(); int n = b.length();
        if (m > n) return false; // Slide a window of size m across b 
        for (int i = 0; i <= n - m; i++) { int j; // Compare window in b with a 
            for (j = 0; j < m; j++) {
                if (b.charAt(i + j) != a.charAt(j)) 
                { 
                    break; // mismatch 
                } 
            } 
            if (j == m) { return true; // full match found 
            }     
        } 
        return false;
    }
}