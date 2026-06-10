class Solution {
    Set<String> set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String str: wordDict){
            set.add(str);
        }
        Map<String, Boolean> map = new HashMap<>();
        // found[0] = true;
        dfs(s, map);
        if(!map.containsKey(s)) return false;
        return map.get(s);
    }

    boolean dfs(String s, Map<String, Boolean> map){
        if(s.length()==0) return true;
        if(map.containsKey(s)) return map.get(s);
        // System.out.println(s); 
        for(int i=0;i<s.length();i++){
            String left = s.substring(0, i+1);
            if(set.contains(left) && dfs(s.substring(i+1),map)){
                map.put(s, true);
                return true;
            }
                
        }
        map.put(s, false);
        return false;
    }

   
}