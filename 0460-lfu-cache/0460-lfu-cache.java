class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int cap;
    int min = -1;
    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count+1);

        //remove and add
        lists.get(count).remove(key);

        //min determines the lfu
        if(count==min && lists.get(count).size()==0)
            min++;
        if(!lists.containsKey(count+1))
            lists.put(count+1, new LinkedHashSet<>());
        lists.get(count+1).add(key);


        return vals.get(key);
    }
    
    public void put(int key, int value) {
        //no capacity to put
        if(cap<=0)
            return;

        //cache has key, then increase count and rearrange in appropriate list
        if(vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        } 

        //cache eviction
        if(vals.size() >= cap) {

            //get min key from list with min count,
            //remove from list and values map
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);counts.remove(evit);
        }

        //
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */