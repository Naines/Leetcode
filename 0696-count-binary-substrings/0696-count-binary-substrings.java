class Solution {
    //00110011
    public int countBinarySubstrings(String s) {
        int groups[]=new int[s.length()];
        int t=0;
        for(int i=0;i<s.length();i++){
            if(i>0 && s.charAt(i)!=s.charAt(i-1)){
                groups[++t]=1;
            }else{
                groups[t]++;
            }
        }

        int ans = 0;
        for(int i=1;i<=t;i++){
            ans+=Math.min(groups[i-1], groups[i]);
        }
        return ans;
    }
}