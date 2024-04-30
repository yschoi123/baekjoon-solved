
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        int sameCnt = 0;

        for(int i=0; i<str1.length(); i++) {
            int idx = str2.indexOf(str1.charAt(i));
            if(idx != -1) {
                sameCnt++;
                str2 = str2.substring(0, idx) + "_" + str2.substring(idx+1);
            }
        }

        int ans = str1.length() + str2.length() - sameCnt * 2;
        System.out.print(ans);
    }
}
