class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr==null || arr.length==0) return new int[0];
        int n = arr.length;
        int ans[] = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0] );

        for(int i=0;i<n;i++){
            //val, idx
            pq.add(new int[]{arr[i], i});
        }
        
        int rank =1;
        int prev[]=pq.poll(), curr[];
        ans[prev[1]]=rank;
        while(pq.size()>0){
            curr=pq.poll();
            if(curr[0]==prev[0]){
                ans[curr[1]]=rank;
            }else{
                ans[curr[1]]=++rank;
            }
            prev=curr;
        }
        return ans;
    }
}