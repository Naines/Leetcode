class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        Map<String, Boolean> map = new HashMap<>();
        return dfs(s, wordDict, map);
    }

    boolean dfs(String s, List<String> wordDict, Map<String, Boolean> map){
        if(s.length()==0) return true;
        if(map.containsKey(s)) return map.get(s);

        for(int i=0;i<s.length();i++){
            String left = s.substring(0,i+1);
            if(wordDict.contains(left)){
                String right = s.substring(i+1);
                boolean res = dfs(right, wordDict, map);
                if(res){
                    map.put(right, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}