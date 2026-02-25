class Solution {

    int countOnes(int n){
        int count = 0;
        while(n>0){
            n = n&n-1;
            count++;
        }
        return count;
    }
    Comparator<Integer> comparator = Comparator.comparingInt(this::countOnes).thenComparingInt(Integer::intValue);

    public int[] sortByBits(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        return Arrays.stream(arr).
                boxed().sorted(comparator)
                .mapToInt(Integer::intValue).toArray();
    }
}