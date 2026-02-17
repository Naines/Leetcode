class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int l=0,ans=0,n=fruits.length,r=0;
        for(r=0;r<n;r++){
            map.put(fruits[r], map.getOrDefault(fruits[r],0)+1);
            if(map.size()>2){
                map.put(fruits[l], map.get(fruits[l])-1);
                if(map.get(fruits[l])==0) map.remove(fruits[l]);
                l++;
            }
            if(map.size()<=2)
            ans = Math.max(ans, r-l+1);
        }
        return ans;
        
        // BRUTE FORCE
        // int ans =0, n=fruits.length;
        // for(int i=0;i<n;i++){
        //     int map[]=new int[20000];
        //     int k=2;
        //     int j=i;
        //     for(j=i;j<n;j++){
        //         if(map[fruits[j]]==0){
        //             k--;
        //         }
        //         if(k<0){
        //             break;
        //         }
        //         map[fruits[j]]++;
        //     }
        //     ans = Math.max(ans, j-i);
        // }
        // return ans;
    }
}