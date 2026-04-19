class Solution {
    //23
    //a b c
    //ad ae af bd be bf cd ce cf
    String words[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        dfs(digits,ans,0, new StringBuilder());
        return ans;
    }
    void dfs(String digits, List<String> ans, int i, StringBuilder sb){
        if(sb.length()==digits.length()){
            ans.add(sb.toString());
            return;
        }
        // System.out.println(sb.toString());
        // System.out.println("hre");

        //abc
        //a
        //
        String word = words[digits.charAt(i)-'0'];
        // System.out.println(word);
        for(char c: word.toCharArray()){
            // System.out.println(c);
            sb.append(c);
            dfs(digits, ans, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}