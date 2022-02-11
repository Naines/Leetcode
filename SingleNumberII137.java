import java.util.Scanner;

public class SingleNumberII137 {
    public static int solve(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1)
                    sum++;
                sum = sum % 3;

            }
            if (sum != 0) {
                ans = ans | sum << i;
                // System.out.println("-------------------" + ans + "------");
            }
            // System.out.println(i + " " + sum);
        }
        return ans;
    }

    // same but uses mask
    public static int solve1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            int mask = 1 << i;
            for (int n : nums) {
                if ((n & mask) != 0)
                    sum++;
                sum = sum % 3;

            }
            if (sum != 0) {
                ans = ans | sum << i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(solve1(arr));
        sc.close();
    }
}
