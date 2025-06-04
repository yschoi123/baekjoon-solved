import java.io.*;
import java.util.*;

public class Main {
	static long[][] mem;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			 n = Integer.parseInt(st.nextToken());
			 m = Integer.parseInt(st.nextToken());

			 if(n == 1) {
				 bw.write(m+"\n");
				 continue;
			 }

			mem = new long[n][m+1];
			for(int i = 0; i<n; i++) {
				Arrays.fill(mem[i],-1);
			}

			long count = solve(n-1, m);

			bw.write(count+"\n");
		}
		bw.close();
	}

	static long solve(int idx, int value) {

		if(value == 0) {
			return 0;
		}
		if(idx==0) {
			return value;
		}

		if(mem[idx][value] == -1) {
			mem[idx][value]	= solve(idx-1, value/2) + solve(idx, value-1);
		}
		return mem[idx][value];
	}

}
