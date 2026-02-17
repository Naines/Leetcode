class Solution {
    public String minWindow(String str, String ttr) {
        int l=0,n1=str.length(), n2=ttr.length(), ans=Integer.MAX_VALUE, cnt=0, startIndex=-1;
        char s[]=str.toCharArray(), t[]=ttr.toCharArray();
        int map[]=new int[256];
        for(char c:t) map[c]++;
        for(int r=0;r<n1;r++){
            if(map[s[r]]>0) cnt++;
            map[s[r]]--;
            //System.out.println(r+" "+l+" "+s[r]+" "+cnt);
            while(cnt==t.length){
                if((r-l+1)<ans){
                    ans = r-l+1;
                    startIndex = l;
                }
                map[s[l]]++;
                if(map[s[l]]>0) cnt--;
                l++;
            }
        }
        //System.out.println(startIndex+" "+ans);
        return startIndex==-1?"":str.substring(startIndex, startIndex+ans);
    }
}