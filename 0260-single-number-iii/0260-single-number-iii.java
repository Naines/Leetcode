class Solution {
    public int[] singleNumber(int[] nums) {
        int xor= 0;
        for(int n: nums) xor^=n;

        //xor contains both nums
        int setBit = ((xor)&(xor-1))^(xor);

        int a=0, b=0;
        for(int n: nums){
            if((setBit & n)!=0){
                a^=n;
            }else{
                b^=n;
            }
        }

        return new int[]{a, b};
    }
}