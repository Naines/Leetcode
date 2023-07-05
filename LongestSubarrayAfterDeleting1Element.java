public class LongestSubarrayAfterDeleting1Element {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 1 };
        int left = 0, n = arr.length;
        int count = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            count += arr[i] == 0 ? 1 : 0;
            while (count > 1) {
                count -= arr[left] == 0 ? 1 : 0;
                left++;
            }
            ans = Math.max(ans, i - left);
        }
        System.out.println(ans);
        solve(arr, n);
    }
    static void solve(int arr[], int n){
        int start=0,ans=0,lastZero=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                start = lastZero+1;
                lastZero = i;
            }
            ans = Math.max(ans, i-start);
        }
        System.out.println(ans);
    }
}
