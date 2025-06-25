import java.io.*;
import java.util.*;


public class Main {

	static final int MAX = 100000;

	static int[] time = new int[MAX+1];
	static int n;
	static int k;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		// 넓이 우선 탐색을 이용해서 최소 시간 구하기
		bfs();

		// 최소 시간 출력
		System.out.println(time[k]);
	}

	static void bfs() {

		Deque<Integer> queue = new LinkedList<>();
		queue.add(n);

		while (!queue.isEmpty()) {
			int x = queue.poll();

			if(x == k) {
				return;
			}
			// 좌로 이동
			if(verifyMovable(x-1)) {
				queue.add(x-1);
				time[x-1] = time[x] + 1;
			}

			// 우로 이동
			if(verifyMovable(x+1)) {
				queue.add(x+1);
				time[x+1] = time[x] + 1;
			}

			// 순간 이동
			if(verifyMovable(x*2)) {
				queue.add(x*2);
				time[x*2] = time[x] + 1;
			}
		}
	}

	static boolean verifyMovable(int x) {
		return x >= 0 && x < time.length && time[x] == 0;
	}

}

