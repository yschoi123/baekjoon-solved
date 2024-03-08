import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        // 크로아티아 알파벳 리스트
        String[] crotian = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};


        for (int i = 0; i < crotian.length; i++) {
            if(word.contains(crotian[i])){
                word = word.replace(crotian[i], "*");
            }
        }
        System.out.print(word.length());

    }
}