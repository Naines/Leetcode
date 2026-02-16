class Solution {
     static String keypad[]={"0", "1", "abc", "def", "ghi", "jkl", "mno","pqrs","tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String>list=new ArrayList<>();
        dfs(list, 0, digits, new StringBuilder());
        return list;
    }
    
    static void dfs(List<String> list, int i, String digits, StringBuilder sb)
    {
        if(sb.length()==digits.length()){
            list.add(sb.toString());
            return;
        }

        String currKeySet = keypad[digits.charAt(i)-'0'];
        for(char c: currKeySet.toCharArray()){
            sb.append(c);
            dfs(list, i+1, digits, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}