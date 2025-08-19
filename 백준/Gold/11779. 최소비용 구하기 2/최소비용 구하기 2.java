import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 도시 개수, 버스 개수
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		List<Node>[] graph = new LinkedList[n + 1];
		// 버스 정보
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if (graph[start] == null) {
				graph[start] = new LinkedList<>();
			}

			graph[start].add(new Node(end, cost));
		}

		// 출발점, 도착점
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		/* 최소 비용, 경로 구하기 */
		// 최소 비용 및 경로 배열 초기화
		int[] minCost = new int[n + 1];
		int[] pre = new int[n+1];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		minCost[start] = 0;

		// 최소 비용 탐색 및 경로 추적
		PriorityQueue<Node> queue = new PriorityQueue<>(1, new NodeComparator());
		queue.add(new Node(start, 0));
		while (!queue.isEmpty()) {
			// 큐에서 최소 비용의 노드 꺼내기
			Node target = queue.poll();
			// 최소 비용 배열과 정보가 맞지 않으면 스킵
			if(target.cost != minCost[target.v] || graph[target.v] == null) {
				continue;
			}

			for(Node next : graph[target.v]) {
				if(next.cost + target.cost >= minCost[next.v]) {
					continue;
				}

				minCost[next.v] = next.cost + target.cost;
				queue.add(new Node(next.v, minCost[next.v]));
				// 이전 경로 저장
				pre[next.v] = target.v;
			}
		}

		// 최소 비용 및 경로 출력
		System.out.println(minCost[end]);

		Deque<Integer> stack = new ArrayDeque<>();
		stack.addLast(end);
		int count = 1;
		int preCity = pre[end];
		while (preCity != start) {
			stack.addLast(preCity);
			preCity = pre[preCity];
			count += 1;
		}
		stack.addLast(start);

		System.out.println(count+1);
		while (!stack.isEmpty()) {
			System.out.print(stack.pollLast()+" ");
		}
	}
}

class Node {
	int v;
	int cost;

	Node(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
}

class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		if(o1.cost == o2.cost) {
			return o1.v - o2.v;
		}

		return o1.cost - o2.cost;
	}
}

