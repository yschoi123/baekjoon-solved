import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Deque<int[]> deque = new ArrayDeque<>();

		// 풍선 세팅
		String[] nums = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			deque.offerLast(new int[]{i+1, Integer.parseInt(nums[i])});
		}

		// 1번 풍선 터뜨리기
		int[] next = deque.pollFirst();

		while(deque.isEmpty() == false) {
			bw.write(next[0] + " ");
			if( next[1] > 0 ) {
				// 양수면 오른쪽 방향으로
				while(next[1]-- > 1) {
					int[] value = deque.pollFirst();
					deque.offerLast(value);
				}
				next = deque.pollFirst();
			} else {
				// 음수면 왼쪽 방향으로
				next[1] *= -1;
				while(next[1]-- > 1) {
					int[] value = deque.pollLast();
					deque.offerFirst(value);
				}
				next = deque.pollLast();
			}
		}
		bw.write(next[0] + " ");
		bw.close();

	}
}
