import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class SubArraySumEqualsK {
    static int memo[] = new int[100];

    static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return subarraySum(nums, k, 0);
    }

    static int subarraySum(int[] nums, int k, int from) {
        if (from >= nums.length) {
            return 0;
        }

        int result = 0;

        int sum = 0;
        for (int i = from; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                result += 1;
            }
        }

        return result + subarraySum(nums, k, from + 1);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int x = fs.nextInt();
        int arr[] = fs.readArray(n);

        Arrays.fill(memo, -1);

        System.out.println(subarraySum(arr, x));
    }

    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}