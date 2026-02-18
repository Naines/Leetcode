class Solution {
    public int repeatedStringMatch(String a, String b) {
        String tmpa=a;
        int ans =1;
        while(a.length()<b.length()){
            a+=tmpa;
            ans++;
        }
        if(substr(b,a)) return ans;
        a+=tmpa;
        if(substr(b,a)) return ans+1;
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