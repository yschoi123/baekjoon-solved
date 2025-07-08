import java.io.*;
import java.util.Arrays;

public class Main {

	static int[] grapes;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		grapes = new int[n+1];
		for(int i=0; i<n; i++) {
			grapes[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(solve(n));
	}

	public static int solve(int n) {

		int[][] dp = new int[n][3];

		dp[0][0] = 0;
		dp[0][1] = dp[0][2] = grapes[0];

		for(int i=1; i<n; i++) {
			// 1. i번째 포도주는 제외한 경우
			dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));

			// 2. i, i-1 번째 포도주를 선택한 경우
			dp[i][1] = grapes[i] + dp[i-1][2];

			// 3. i번째 포도주만 선택한 경우
			dp[i][2] = grapes[i] + dp[i-1][0];
		}

		return Arrays.stream(dp[n-1])
			.max()
			.getAsInt();
	}


}

