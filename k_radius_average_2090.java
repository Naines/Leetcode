import java.util.Arrays;

/**
 * k_radius_average_2090
 * *
 */
public class k_radius_average_2090 {

    static int[] avg(int arr[], int k){
        int n = arr.length;
        int ans[] = new int[n];
        long sum = 0;
        int i = 0;
        while (i < 2 * k + 1 && i<n) {
            if (i < k)
                ans[i] = -1;
            sum += arr[i];
            i++;
        }
        int left = 0, right = 2*k;

        for (i=k; i < n; i++) {
            if(i+k>=n){
                ans[i] = -1;
                continue;
            }
            ans[i] = (int)(sum/(2*k+1));
            sum-=arr[left];
            if(right+1<n) sum+=arr[right+1];
            left++;right++;
        }
        return ans;
    }


    static int[] solve(int arr[], int k) {
        int n = arr.length;
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
    
        if(2*k+1>n) return ans;
        long sum = 0;
        for(int i=0;i<2*k+1;i++) sum+=arr[i];

        for(int i=k;i<=n-k-1;i++){
            ans[i]=(int)sum/(2*k+1);
            sum-=arr[i-k];
            if(i-k+1<n) sum+=arr[i-k+1];
        }
        return ans;
    }
    // 7 4 3 9 1 8 5 2 6

    public static void main(String[] args) {
        // int arr[] = { 7, 4, 3, 9, 1, 8, 5, 2, 6 };
        int arr[] = {8};
        int k = 0;
        System.out.println(Arrays.toString(solve(arr, k)));

    }

}