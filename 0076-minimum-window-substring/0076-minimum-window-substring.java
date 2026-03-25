class Solution {
    public String minWindow(String s, String t) {
        int n1=s.length(),n2=t.length(),ans=Integer.MAX_VALUE,cnt=0,start=-1,l=0;
        int map[]=new int[256];
        for(char c: t.toCharArray()) map[c]++;
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            if(map[ch]>0) cnt++;
            map[ch]--;
            while(cnt==t.length()){
                if((r-l+1)<ans){
                    ans = r-l+1;
                    start=l;
                }
                map[s.charAt(l)]++;
                if(map[s.charAt(l)]>0) cnt--;
                l++;
            }
        } 
        //System.out.println(start+" "+ans);
        return start==-1?"":s.substring(start,start+ans);
    }
}