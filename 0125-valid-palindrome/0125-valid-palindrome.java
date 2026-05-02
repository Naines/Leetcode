class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(char c: s.toLowerCase().toCharArray()){
            //48<=c<=57
            //97<=c<=122
            if((c>47 && c<58) || (c>96 && c<123)){
                sb.append(c);
            }
        }
        for(int i=0;i<sb.length()/2;i++){
            if(sb.charAt(i)!=sb.charAt(sb.length()-i-1)) return false;
        }
        return true;
    }
}