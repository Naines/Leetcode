class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr.length==1){
            if(arr[start]==0)   return true;
            return false;
        }
        if(arr[start]==0)   return true;
        
        return dfs(arr,start)  ;
    }
    boolean dfs(int arr[], int i){
        if(i<0 || i>=arr.length || arr[i]<0){
            return false;
        }        
        if(arr[i]==0)   return true;
        arr[i]=-arr[i]; //mark vis
        return dfs(arr, i+arr[i]) || dfs(arr, i-arr[i]);
    }
}