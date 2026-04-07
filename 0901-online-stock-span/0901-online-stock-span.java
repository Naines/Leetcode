/**
pse only needed
100,80,60,70,60,75,85
arr[stk.peek()]<=arr[i]
stk:100,85
pse:-1,-1,-1,60,-1,70,80
if(pse==-1) return 1;
else return i-pse[i]+1

31,41,48,59,79
59
*/
class StockSpanner {
    Stack<Integer> stk;
    int n;
    List<Integer> list;
    public StockSpanner() {
        n=0;
        list=new ArrayList<>();
        stk=new Stack<>();
    }
    
    public int next(int price) {
        int ans =0;
        while(!stk.isEmpty() && list.get(stk.peek())<=price){
            stk.pop();
        }
        if(!stk.isEmpty()){
            ans= n-stk.peek();
        }else{
            ans=n+1;
        }
        stk.push(n++);
        list.add(price);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */