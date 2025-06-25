import java.io.*;
import java.util.*;


public class Main {

	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0, 1};

	static int n = 0;
	static int m = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 미로 입력 받기
		int[][] maze = new int[n][m];
		for(int i=0; i<n; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				maze[i][j] = row[j]-'0';
			}
		}

		// 넓이 우선 탐색을 이용해서 이동 거리 구하기
		bfs(maze);

		// 최소 칸 수 출력
		System.out.println(maze[n-1][m-1]);
	}

	static void bfs(int[][] maze) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0 , 0));

		// 상하좌우로 인접한 노드 탐색
		while(!queue.isEmpty()) {
			Node node = queue.poll();

			// 상하좌우로 탐색
			for(int i=0; i<4; i++) {
				int conX = node.x + dx[i];
				int conY = node.y + dy[i];
				if(validRange(conX,conY) && maze[conX][conY] == 1) {
					// 탐색 대상으로 추가
					queue.add(new Node(conX, conY));

					// 이동 거리 합치기(방문 체크)
					maze[conX][conY] = maze[node.x][node.y] + 1;
				}
			}
		}

	}

	static boolean validRange(int x, int y) {
		return (x >= 0 && x <n) && (y >= 0 && y < m);
	}
}

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}