import java.util.Arrays;

public class CanMakeAp1502 {
    static boolean check(int arr[], int n){
        Arrays.sort(arr);
        for(int i=2;i<n;i++){
            if(2*arr[i-1] - (arr[i]+arr[i-2]) !=0)
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int arr[]={3,5,1};
        System.out.println(check(arr, arr.length));
    }
}
