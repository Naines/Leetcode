class Solution {

    /**
        11160
        1  11
        1 160
        160

    */
    Map<String, String> map=new HashMap<>();
    Map<String, Integer> dp = new HashMap<>();
    public int numDecodings(String s) {
        for(int i=65;i<=90;i++){
            map.put(String.valueOf(i-64), String.valueOf((char)i));
        }
        return dfs(s);
    }

    int dfs(String s){
        if(s.length()==0) 
            return 1;

        if(dp.containsKey(s)) 
            return dp.get(s);

        if(s.charAt(0)=='0'){
            dp.put(s,0);
            return 0;
        }

        int total = 0;
        for(int i=0;i<s.length();i++){
            String left = s.substring(0, i+1);
            if(map.containsKey(left)){
                String right = s.substring(i+1);
                total+=dfs(right);
            }
        }
        dp.put(s, total);
        return dp.get(s);
    }
}