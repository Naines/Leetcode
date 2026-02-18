class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int revNum = 0, n=x;
        while(n>0){
            revNum = revNum*10+n%10;
            n=n/10;
        }
        return revNum==x;

    }
}