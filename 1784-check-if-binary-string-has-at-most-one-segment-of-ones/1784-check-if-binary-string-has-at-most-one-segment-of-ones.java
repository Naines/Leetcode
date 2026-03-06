class Solution {
    public boolean checkOnesSegment(String s) {
        if(s.length()==1 && s.charAt(0)=='1') return true;
        boolean flag = false;
        for(int i=1;i<s.length();i++){
            if(flag==false && s.charAt(i)!=s.charAt(i-1)){
                flag=true;
                continue;
            }else if(flag==true && s.charAt(i)!=s.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
}