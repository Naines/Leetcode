class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n =hand.length;
        if(n%groupSize!=0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int x: hand) map.put(x, map.getOrDefault(x, 0)+1);

        while(!map.isEmpty()){
            int key =  map.firstKey();
            int count = map.get(key);
            for(int i=0;i<groupSize;i++){
                int requiredCard = key+i;
                if(!map.containsKey(requiredCard) || map.get(requiredCard)<count){
                    return false;
                }
                if (map.get(requiredCard) == count) map.remove(requiredCard);
                else map.put(requiredCard, map.get(requiredCard) - count);
            }
        }

        return true;
    }
}