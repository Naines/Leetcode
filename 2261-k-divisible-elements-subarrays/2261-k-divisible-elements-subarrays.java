class Solution {
    //len<=k
    //1+2+3+4
    //rrrrr
    //.l
    //23322
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set=new HashSet<>();
        for(int l=0;l<nums.length;l++){
            int size=0;
           StringBuilder sb=new StringBuilder();
           for(int r=l;r<nums.length;r++){
            if(nums[r]%p==0) size++;
            if(size>k) break;
            sb.append(nums[r]+",");
            set.add(sb.toString());
           }
        }
        return set.size();
    }
}