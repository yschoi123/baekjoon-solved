
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];

        for(int i=0; i<n; i++) {
            coins[i] = Integer.valueOf(br.readLine());
        }

        System.out.println(solve(coins, k));

    }

    static int solve(int[] coins, int k) {

        int[] dp = new int[100001];
        dp[0] = 1;

        for(int coin: coins) {
            for(int i=coin; i<=k; i++) {
                dp[i] += dp[i-coin];
            }
        }

        return dp[k];
    }

}
