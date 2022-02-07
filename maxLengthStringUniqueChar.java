import java.util.ArrayList;
import java.util.List;

/**
 * maxLengthStringUniqueChar
 */
public class maxLengthStringUniqueChar {

    static int ans = 0;

    static void solve(List<String> arr) {
        dfs(arr, "", 0);
        System.out.println(ans);
    }

    static void dfs(List<String> arr, String str, int idx) {
        boolean unique = isUnique(str);
        if (unique)
            ans = Math.max(ans, str.length());
        if (!unique || idx == arr.size())
            return;
        for (int i = idx; i < arr.size(); i++) {
            dfs(arr, str + arr.get(i), i + 1);
        }
    }

    static boolean isUnique(String s) {
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++)
            alpha[s.charAt(i) - 'a']++;
        for (int i = 0; i < alpha.length; i++)
            if (alpha[i] > 1)
                return false;
        return true;
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        String str = "abcdefghijklmnop";
        for (char c : str.toCharArray()) {
            arr.add(c + "");
        }
        solve(arr);
    }
}