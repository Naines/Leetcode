class Solution {
    Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
    int countSetBits(int num){
        int count =0;
        while(num>0){
            count+=(num&1);
            num=num>>1;
        }
        return count;
    }

    public int countPrimeSetBits(int left, int right) {
        int ans=0;
        for(int i=left;i<=right;i++){
            int c = countSetBits(i);
            if(set.contains(c)) ans++;
        }
        return ans;
    }
}