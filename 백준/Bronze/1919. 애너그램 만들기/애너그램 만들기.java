
import java.util.*;
public class Main {
    public static int[] countString(String str) {
        int[] count = new int[26];
        for(int i=0; i<str.length(); i++) {
            count[str.charAt(i)-'a']++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        int[] str1Count = countString(str1);
        int[] str2Count = countString(str2);

        int ans = 0;

        for(int i=0; i<str1Count.length; i++) {
            ans += Math.abs(str1Count[i]-str2Count[i]);
        }
        System.out.print(ans);
    }
}
