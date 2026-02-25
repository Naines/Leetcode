class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long days = 0;
        Map<Integer, Long> lastDay = new HashMap<>();
        for(int x: tasks){
            if(!lastDay.containsKey(x))
                lastDay.put(x, ++days);
            else{
                days = Math.max(days, lastDay.get(x)+space) + 1;
                lastDay.put(x, days); 
            }
        }
        return days;
    }
}