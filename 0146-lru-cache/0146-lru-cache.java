class LRUCache {
    static class Node{
        int k;
        int v;
        Node prev, next;
        Node(){
            // this.v = ;
            // this.k = -1;
        }
        Node(int k, int v){
            this.k=k;
            this.v= v;
        }
    }
    int capacity = 0, count = 0;
    Map<Integer, Node> map= new HashMap<>();
    Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev= head;
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key))
        return -1;
        Node n = map.get(key);
        update(n);
        return n.v;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            Node n = new Node(key, value);
            map.put(key, n);
            add(n);
            count++;
        
        }else{
            Node n = map.get(key);
            n.v = value;
            update(n);
        }

        //delete least recently used in case of overflow
        if(count > capacity){
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.k);
            count--;
        }
        // print(head);
        // System.out.println("Size="+map.size());
        return;
    }


    //////////////////////////////////////
    void update(Node n){
        
        remove(n);
        add(n);
    }

    void add(Node n){  
        Node t = head.next;
        head.next=n;
        n.next=t;
        n.prev= head;
        t.prev=n;
    }

    void remove(Node n){
        Node t = n.prev, after = n.next;
        t.next  = after;
        after.prev = t;
    }

    void print( Node head){
        Node t = head;
        while(t!=null){
            System.out.print(t.v+"-");
            t=t.next;
        }
        System.out.println();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */