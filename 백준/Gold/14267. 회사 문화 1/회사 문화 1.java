
import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer>[] underings;
    public static int[] bossPraise;
    public static int[] praise;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        underings = new ArrayList[n];
        praise = new int[n+1];
        bossPraise = new int[n+1];

        // 상사 - 부하 직원 정보 저장
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if(boss == -1) {
                boss = 0;
            }

            if(underings[boss] == null) {
                underings[boss] = new ArrayList<>();
            }
            underings[boss].add(i);
        }

        // 칭찬 받기
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            bossPraise[i] += w;
        }

        for(int i=1; i<=n; i++) {
            int boss = i;
            int score = bossPraise[i];
            if(score != 0) {
                relayPraise(boss, score);
            }

        }

        for(int i=1; i<=n; i++) {
            System.out.print(praise[i] + " ");
        }

    }

    public static void relayPraise(int e, int score) {

        praise[e] += score;
        if(e == underings.length || underings[e] == null) {
            return;
        }

        for(int i=0; i<underings[e].size(); i++) {
            int under = underings[e].get(i);
            relayPraise(under, score);
        }


    }

}
