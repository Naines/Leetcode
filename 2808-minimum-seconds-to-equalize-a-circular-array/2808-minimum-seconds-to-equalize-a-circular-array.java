class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int n= nums.size();
        if(n<=1) return 0; 
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums.get(i), k-> new ArrayList()).add(i);
        }

        int ans = n;
        for(List<Integer> pos: map.values()){
            int m=pos.size();
            int mg;
            if(m==1){
                mg=n;
            }else{
                mg=0;
                for(int i=1;i<m;i++){
                    int gap = pos.get(i) - pos.get(i-1);
                    mg=Math.max(mg, gap);
                }
                int w= pos.get(0)+n-pos.get(m-1);
                mg=Math.max(w, mg);
            }
            int nights = mg/2;
            ans=Math.min(nights, ans);
        }
        return ans;
    }
}