class MedianFinder {

    PriorityQueue<Integer> minq=new PriorityQueue<>();
    PriorityQueue<Integer> maxq=new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        
    }

    public void addNum(int num) {
        maxq.add(num);
        minq.add(maxq.poll());
        if(minq.size()>maxq.size()){
            maxq.add(minq.poll());
        }
    }
    
    public double findMedian() {
        if(maxq.size()==minq.size()){
            return (minq.peek()+maxq.peek())/2.0;
        }
        return maxq.peek();
    }
    

    //dont work for negative
    // public void addNum(int num) {
    //     minq.add(num);
    //     if(minq.size()-maxq.size()==2){
    //         maxq.add(minq.poll());
    //     }
    // }
    
    // public double findMedian() {
    //     if(maxq.size()==minq.size()){
    //         return (minq.peek()+maxq.peek())/2.0;
    //     }
    //     return minq.peek();
    // }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */