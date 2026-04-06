class Solution {

    //7685 -> 685 if desc, remove first
    //1234 -> 123, if asc, remove last
    //1432 -> 1,4, 3 -> pop 4
    //stk: 13 . if k=2, ans = 12

    //2100200 ->  100200

    //make monotonic increasing stack
    public String removeKdigits(String num, int k) {
        Stack<Integer> stk = new Stack<>();
        int n = num.length(), i=0,count=0;
        while(i<n){
            int x = num.charAt(i)-'0';

            //while(cond valid) keep popping
            while(!stk.isEmpty() && count<k && stk.peek()>x){
                stk.pop();
                count++;
            }
            stk.push(x);
            i++;
        }

        //rest remove from monotonic stack
        //10200 -> 0200
        while(count<k){
            stk.pop();
            count++;
        }

        //sb:
        StringBuilder sb=new StringBuilder();
        while(!stk.isEmpty()){
            int d=stk.pop();
            //0200 -> stk: 0,0,2,0
            sb.append(d); //200
        }
        sb.reverse();
        //0200
        i=0;
        if(sb.length()>0 && sb.charAt(i)=='0'){
            while(i<sb.length() && sb.charAt(i)=='0') 
                i++;
        } 
        //10200, 2 -> 0200,000
        return sb.length()==0 || i==sb.length()?"0":sb.substring(i, sb.length()).toString();
    }
}