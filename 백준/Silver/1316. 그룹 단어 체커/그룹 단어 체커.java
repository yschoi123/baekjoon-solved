import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;
        while(n-- > 0){
            String word = sc.next();
            boolean isGroup = true;
            for(int i=0; i<word.length(); i++){
                // i번째 문자와 동일한 문자가 존재하는 다음 인덱스
                int nextIdx = word.indexOf(word.charAt(i), i+1);
                if(nextIdx == -1){
                    continue;
                } else if(nextIdx-1 != i){
                    isGroup = false;
                    break;
                }
            }

            if(isGroup){
                count++;
            }
        }
        System.out.print(count);
    }


}