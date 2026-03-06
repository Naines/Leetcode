class Solution {
    //0-1
    public int myAtoi(String s) {
        s=s.trim();
        int n = s.length();
        if(n==0) return 0;
        int i=0, sign = 1;
        long num = 0;
     
        if(s.charAt(i)=='+'){
            i++;
            sign = 1;
        }else if(s.charAt(i)=='-'){
            i++;
            sign =-1;
        }
        for(;i<n;i++){
            //2147483647
            if(num>Integer.MAX_VALUE){
                if(sign==-1) return Integer.MIN_VALUE;
                if(sign==1) return Integer.MAX_VALUE;
            }
            char ch = s.charAt(i);
            System.out.println(ch+" "+i);
            if(ch=='0' && i==0) continue;
            
            if(Character.isDigit(ch)) 
                num=num*(long)10+(ch-'0');
            else break;
        }
        System.out.println(num);
        System.out.println(Integer.MAX_VALUE);
        num = sign==1?num:sign==-1?num*-1:num;
        return num>=Integer.MAX_VALUE?Integer.MAX_VALUE:num<=Integer.MIN_VALUE?Integer.MIN_VALUE:(int)num;
    }
}