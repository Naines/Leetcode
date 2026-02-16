class Solution {
    ArrayList<String> list=new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) 
    {
        solve(s, wordDict, "");
        return list;
    }
    
    void solve(String str, List<String> dict, String ans)
    {
        if(str.length()==0)
        {
            list.add(ans.substring(0,ans.length()-1)); 
            return;
        }
        
        for(int i=0;i<str.length();i++)
        {
            String left=str.substring(0,i+1);
            if(dict.contains(left))
            {
                String right=str.substring(i+1);
                solve(right, dict, ans+left+" ");
            }
        }
    }
}