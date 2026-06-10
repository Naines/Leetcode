class Solution {
    /**
        generate all possible strings 
        cat -> sand -> dog
        left + " "+right

        cats -> and -> dog 
    
     */

    List<String> ans;
    Set<String> set=new HashSet<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        for(String str: wordDict) set.add(str);
        dfs(s,new StringBuilder());
        return ans;
    }

    void dfs(String s, StringBuilder sb){
        if (s.length() == 0) {
            ans.add(sb.substring(0, sb.length() - 1));
            return;
        }

        for (int i=0; i<s.length(); i++) {
            String left = s.substring(0, i+1);
            if (set.contains(left)) {
                int lenBefore = sb.length();
                sb.append(left).append(" ");
                dfs(s.substring(i + 1), sb);
                sb.setLength(lenBefore);
            }
        }
    }
}