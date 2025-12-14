class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head, tail;
    int count;
    
    public LRUCache(int capacity) {
       this.capacity = capacity;
       this.count =0;
       map = new HashMap<>();
       head = new Node();
       tail = new Node();
       head.next = tail;
       tail.prev= head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(n == null){
            return -1;
        }
        update(n);
        return n.v;
    }
    
    public void put(int k, int v) {
       Node n = map.get(k);
       if(n==null){
        //create and add to list and map
        n = new Node(k, v);
        map.put(k, n);
        add(n);
        count++;
       }else{
        //update
        n.v = v;
        update(n);
       }
        //reset
       if(count > capacity){
        Node toDel = tail.prev;
        remove(toDel);
        map.remove(toDel.k);
        count--;
       }
    }

    private void update(Node n){
        remove(n);
        add(n);
    }

    //add after head node
    private void add(Node n){
        Node after = head.next;
        head.next = n;
        n.prev = head;

        n.next = after;
        after.prev= n;

    }

    //remove node before tail
    private void remove(Node n){
        Node before = n.prev, after = n.next;
        before.next = after;
        after.prev= before;
    }


     static class Node{
        int k, v;
        Node prev, next;
        Node(int k, int v){
            this.k = k;
            this.v =v;
            
        }
        Node(){
            System.out.println("Node init");
            this(0,0);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */