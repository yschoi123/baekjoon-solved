import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        str = str.toUpperCase();
        int[] count = new int['Z'-'A'+1];

        // 알파벳 개수 구하기
        for(int i=0; i<str.length(); i++) {
            count[str.charAt(i)-'A']++;
        }

        // 가장 많은 알파벳 구하기
        char ans = '?';
        int maxCount = -1;
        for(int i=0; i<count.length; i++) {
            if(maxCount < count[i]) {
                ans = (char)('A' + i);
                maxCount = count[i];
            } else if(maxCount == count[i]) {
                ans = '?';
            }
        }

        System.out.println(ans);
    }
}