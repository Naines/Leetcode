class Solution {
    //3[a]2[bc] -> 3[a]bcbc ->aaabcbc
    //3[a2[c]] -> 3[acc] -> accaccacc
    //2[abc]3[cd]ef
    int i=0;
    public String decodeString(String s) {
        i=0;
        return decode(s);
    }

    String decode(String s){
        StringBuilder res=new StringBuilder();
        int num=0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10+(c-'0');
                i++;
            }else if(c=='['){
                i++;
                String ans = decode(s);
                for(int k=0;k<num;k++) res.append(ans);
                num=0;
            }else if(c==']'){
                i++;
                return res.toString();
            }else{
                res.append(c);
                i++;
            }
        }
        return res.toString();
    }
}