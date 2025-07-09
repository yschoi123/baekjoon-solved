
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Integer> coinSet = new HashSet<>();

        for(int i=0; i<n; i++) {
            coinSet.add(Integer.valueOf(br.readLine()));
        }

        System.out.println(solve(coinSet, k));

    }

    static int solve(Set<Integer> coins, int k) {

        int[] dp = new int[100001];
        Arrays.fill(dp, 100001);

        for(int coin: coins) {
            if(coin <= k) {
                dp[coin] = 1;
            }
        }

        for(int i=1; i<=k; i++) {
            for(int coin: coins) {
                if(i+coin <= k) {
                    dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
                }
            }
        }

        return dp[k] == 100001 ? -1 : dp[k];
    }

}
