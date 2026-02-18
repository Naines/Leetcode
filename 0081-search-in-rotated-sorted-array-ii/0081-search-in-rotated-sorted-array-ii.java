class Solution {
    public boolean search(int[] a, int target) {
        int lb=0, ub=a.length-1;
        while(lb<=ub){
            int m = (lb+ub)>>1;
            if(a[m]==target) return true;
            if(a[lb]==a[m] && a[m]==a[ub]){
                lb++; ub--;
                continue;
            }
            //left side is sorted?
            if(a[lb]<=a[m]){

                //target lies here?
                if(target>=a[lb] && target<=a[m])
                    ub=m-1;
                else
                    lb=m+1;
            }else{
                
                //target lies ?
                if(target>=a[m] && target<=a[ub]){
                    lb=m+1;
                }else{
                    ub=m-1;
                }
            }
        }
        return false;
    }
}