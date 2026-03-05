class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.equals("")) return true;
        int i=0,j=0;
        int m=s.length(), n=t.length();
        while(i<m && j<n){
            if(s.charAt(i)==t.charAt(j)){
                i++;j++;
            }else{j++;}
        }
        return i==m;
    }
}