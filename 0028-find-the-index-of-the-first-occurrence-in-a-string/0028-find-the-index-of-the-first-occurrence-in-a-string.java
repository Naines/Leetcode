class Solution {
    public int strStr(String a, String b) {
        int m=a.length(), n=b.length();
        if(m<n) return -1;
        for(int i=0;i<=m-n;i++){
            int j=0;
            for(j=0;j<n;j++){
                if(a.charAt(i+j)!=b.charAt(j)) break;
            }
            if(j==n) return i;
        }
        return -1;
    }
}