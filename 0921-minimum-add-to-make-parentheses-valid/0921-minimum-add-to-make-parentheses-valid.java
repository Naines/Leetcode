class Solution {
    public int minAddToMakeValid(String s) {
        int open =0, close=0;
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(stk.isEmpty()) stk.push(c);
            else if(c==')' && stk.peek()=='(') stk.pop();
            else stk.push(c);
        }
        return stk.size();
    }
}