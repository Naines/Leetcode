class Solution {
    /**
            (
         (,  *.   ).
         ),  (,   *,

    (),(*)
    ( count shall be in range [cmin, cmax]
    ( -> increase cmin, cmax
    ) -> descrease cmax, cmin
    * -> increase cmax, decrease cmin

    cmin <0 -> (*****  or ()))))
    in latter case, cmax<0 as well
    in former case, cmax>0 and cmin<0
     */
    public boolean checkValidString(String s) {
        int cmin=0, cmax=0;
        for(char c: s.toCharArray()){
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;cmin--;
            } else if(c=='*'){
                cmax++;
                cmin--;
            }
            if (cmax < 0) return false;
            cmin=Math.max(cmin, 0);
        }
        return cmin==0;
    }
}