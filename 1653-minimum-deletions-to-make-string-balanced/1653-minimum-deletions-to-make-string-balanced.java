class Solution {
    public int minimumDeletions(String s) {
       Stack<Character> stk = new Stack<>();
       int ans =0;
       for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        if(!stk.isEmpty() && stk.peek()=='b' && ch=='a'){
            stk.pop();
            ans++;
        }else{
            stk.push(ch);
        }
       }
       return ans;
    }

   
}