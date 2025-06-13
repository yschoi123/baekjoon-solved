import java.io.*;
import java.util.*;

public class Main {
	static boolean[] check = new boolean[26];
	static char[][] board;
	static int maxCount;
	static int r;
	static int c;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		board= new char[r][c];

		for(int i=0; i<r; i++) {
			board[i] = br.readLine().toCharArray();
		}

		// 백트래킹으로 최대 길 탐색
		backtracking(0, 0, 0);

		// 말이 지날 수 있는 최대 칸 수 출력
		System.out.println(maxCount);

	}

	static void backtracking(int x, int y, int count) {
		// 현재 칸을 지날 수 있는지 확인
		if(x < 0 || x >= r || y < 0 || y >= c || check[board[x][y] - 'A']) {
			maxCount = Math.max(maxCount, count);
			return;
		}

		// 알파벳 체크
		check[board[x][y] - 'A'] = true;

		// 상하좌우 칸으로 이동
		backtracking(x-1, y, count+1);
		backtracking(x, y-1, count+1);
		backtracking(x+1, y, count+1);
		backtracking(x, y+1, count+1);


		// 탐색이 끝나면 알파벳 체크 해제
		check[board[x][y] - 'A'] = false;
	}


}