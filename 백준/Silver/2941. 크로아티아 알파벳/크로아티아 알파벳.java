import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        // 크로아티아 알파벳 리스트
        String[] crotian = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        // 문자 수 담을 변수 선언
        int count = 0;

        int wordLen = word.length();

        for (int i = 0; i < wordLen; ) {
            if (i == word.length() - 1) { // 마지막 알파벳이면 무조건 크로아티아 알파벳이 아님
                count += 1;
                i++;

            } else {
                boolean isCrotian = false;

                // 크로아티아 알파벳 리스트와 차례대로 비교하면서 해당 알파벳이 있는지 확인
                for (int j = 0; j < crotian.length; j++) {
                    // 비교할 수 있는 글자수가 j번째 크로아티아 알파벳의 글자수보다 작으면 패스
                    if(crotian[j].length()>wordLen-i){
                        continue;
                    }

                    // j번째 크로아티아 알파벳과 동일한지 확인
                    if (word.substring(i, i + crotian[j].length()).equals(crotian[j])) {
                        count += 1;
                        i += crotian[j].length();
                        isCrotian = true;
                        break;
                    }
                }

                if (!isCrotian) { // 어떤 크로아티아 알파벳과도 동일한 문자가 없다면 카운트 1 증가
                    count += 1;
                    i++;
                }
            }
        }

        System.out.print(count);

    }
}