class Solution {
    /**

    pre[i]%k = pre[j]%k

        4 5 0 -2 -3 1
    sum:4 9 9  7  4 5
    rem:4 4 4  2  4 0
    ans: 4C2 + 0C2 = 7 




    -1 -9 -4   0 , 9 
    -1 -10 -14 -14
    8   1
     */
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        int count=0, sum=0, rem=0;
        map.put(0,1);
        for(int x: nums){
            sum+=x;
            rem= (sum%k+k)%k;
            count+=map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        return count;
    }
}