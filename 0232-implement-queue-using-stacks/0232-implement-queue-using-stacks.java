class MyQueue {
    Stack<Integer> s1,s2;
    public MyQueue() {
        s1=new Stack<>(); //output stack
        s2=new Stack<>(); //input stack
    }
    
    public void push(int x) {
        s2.add(x);
    }
    //1,2
    //s2:
    //s1: 1,2
    //queue: 
    // ==
    public int pop() {
        peek();
        return s1.pop();
    }
    
    public int peek() {
        if(s1.isEmpty()){
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */