class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length()<4 || s.length()>12) return res;
        dfs(s,res,"",0);
        return res;
    }

    void dfs(String str, List<String> res, String curr, int n){
        if(n==4){
           if(str.length()==0) res.add(curr.substring(0, curr.length()-1));
           return;
        }
        for(int i=1;i<=3;i++){
            if(str.length()<i) continue;
            int ip = Integer.parseInt(str.substring(0,i));
            if(ip>255 || i!=String.valueOf(ip).length()) continue;
            dfs(str.substring(i),res, curr+str.substring(0,i)+".",n+1);
        } 
    }
}