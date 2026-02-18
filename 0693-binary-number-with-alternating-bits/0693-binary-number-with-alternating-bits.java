class Solution {
    public boolean hasAlternatingBits(int n) {
        int initial = n&1;
        n=n>>1;
        while(n>0){
            int bit = n&1;
            if(initial==bit) return false;
            initial = bit;
            n=n>>1;
        }
        return true;
    }
}