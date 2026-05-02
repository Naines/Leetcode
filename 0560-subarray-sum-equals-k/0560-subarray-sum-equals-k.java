class Solution {
    //1 2 3  ;k =3
    //1,2

    //sum=0, ans =0;
    //take sums
    //if(sum-k==0) count++;
    //map.put(sum, map.get(sum)+1)


    ///1,2,1, k=3
    //1-> 1
    //3-> 1 count+=map.get(3-2) =1
    //4-> 1 count+=map.get(3) = 2
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;

        for(int i: nums){
            sum+=i;
            count+=map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}