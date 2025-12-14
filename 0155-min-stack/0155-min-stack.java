class MinStack {
    Stack<Integer> stk1;
    Stack<Integer> stk2;

    public MinStack() {
        stk1 = new Stack<>(); 
        stk2 = new Stack<>();
    }
    
    public void push(int x) {
        if(stk2.isEmpty() || x<=getMin()) stk2.push(x);
        stk1.push(x);
    }
    
    public void pop() {
        if(getMin() == stk1.peek()) stk2.pop();
        stk1.pop();
    }
    
    public int top() {
        return stk1.peek();
    }
    
    public int getMin() {
        return stk2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */