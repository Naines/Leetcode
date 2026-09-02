class Solution {
    //babad
    //.     ans:3, i::0 O(n3)
 
    //start anywhere
    //if on expalnding, palin is not there, break. check around next index i
    
    public String longestPalindrome(String s) {
        String max ="";
        for(int i=0;i<s.length();i++){
            String l1=check(s, i, i); //odd
            String l2=check(s, i, i+1); //even
            if(l1.length()>max.length()) max=l1;
            if(l2.length()>max.length()) max=l2;
        }
        return max;
    }


    String check(String s,int m, int n){
        while(m>=0 && n<s.length() && s.charAt(m)==s.charAt(n)){
            m--;n++;
        }
        //[m+1, n-1]
        return s.substring(m+1, n);
    }
}