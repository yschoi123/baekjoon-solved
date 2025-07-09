
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        int[]  unit = new int[n];
        for(int i=0; i<n; i++) {
            unit[i] = Integer.valueOf(br.readLine());
        }

        // 큰 단위부터 계산해서 최소값 구하기
        int count = 0;
        for(int i=n-1; i>=0; i--) {
            if(k/unit[i] >= 1) {
                count += k/unit[i];
                k %= unit[i];
            }
        }
        System.out.println(count);
    }






}
