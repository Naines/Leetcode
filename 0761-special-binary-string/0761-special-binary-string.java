class Solution {
    public String makeLargestSpecial(String s) {
        int count = 0, l=0;
        List<String> res= new ArrayList<String>();
        for(int r=0;r<s.length();r++){
            if(s.charAt(r)=='1') count++;
            else count--;
            //balanced
            if(count==0){
                res.add('1'+makeLargestSpecial(s.substring(l+1, r))+'0');
                l=r+1;
            }
        }

        Collections.sort(res, Collections.reverseOrder());
        return String.join("",res);
    }
}