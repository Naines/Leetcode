class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk=new Stack<>();
        for(int x: asteroids){
            if(stk.isEmpty() || x>0){
                stk.push(x);
            }else{
                //if peek is +ve or peek>x, destroy
                while(!stk.isEmpty() && stk.peek()>0 && stk.peek()<Math.abs(x)){
                    stk.pop();
                }

                //if peek is -ve, add to stack
                //if peek isequal to x, destroy, dont add
                if(!stk.isEmpty() && stk.peek()==Math.abs(x)){
                    stk.pop();
                }else{
                    if(stk.isEmpty() || stk.peek()<0){
                        stk.push(x);
                    }
                }
            }
        }
        int n=stk.size();
        int ans[]=new int[n];
        while(!stk.isEmpty()){
           ans[--n]=stk.pop();
        }
        return ans;
    }
}