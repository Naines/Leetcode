import java.util.Scanner;

public class PermutationInString {
    static boolean checkInclusion(String s1, String s2) {
        char chs1[] = s1.toCharArray(), chs2[] = s2.toCharArray();
        if (chs2.length < chs1.length)
            return false;
        int hs1[] = new int[26], hs2[] = new int[26];
        for (char ch : chs1)
            hs1[ch - 'a']++;
        for (int i = 0; i < chs2.length; i++) {
            hs2[chs2[i] - 'a']++;
            if (i >= chs1.length)
                hs2[chs2[i - chs1.length] - 'a']--; // this resets if outside the window
            if (matches(hs1, hs2))
                return true;
        }
        return false;
    }

    static boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next(), s2 = sc.next();
        System.out.println(checkInclusion(s1, s2));
        sc.close();
    }
}
