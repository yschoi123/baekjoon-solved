import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.valueOf(st.nextToken());
		int E = Integer.valueOf(st.nextToken());

		// 시작 정점 번호
		int start = Integer.valueOf(br.readLine());

		// 그래프 정보
		List<Node>[] graph = new LinkedList[V+1];
		String input = null;
		while((input = br.readLine()) != null) {
			st = new StringTokenizer(input);
			if(!st.hasMoreElements()) {
				break;
			}
			int u = Integer.valueOf(st.nextToken());
			int v = Integer.valueOf(st.nextToken());
			int w = Integer.valueOf(st.nextToken());

			if (graph[u] == null) {
				graph[u] = new LinkedList<>();
			}

			graph[u].add(new Node(v, w));
		}

		/** 최단 경로 구하기 **/
		int[] d = new int[V+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>(1, new NodeComparator());

		// 시작 정점의 인접 노드 구해서 거리, 큐 초기화
		d[start] = 0;
		pq.add(new Node(start, d[start]));

		// 큐가 비어질 때 까지 모든 노드에 대해 최단 경로 구하기
		while(!pq.isEmpty()) {
			// 현재 가장 짧은 거리의 노드 구하기
			Node shortest = pq.poll();

			// 이미 더 짧은 거리가 계산된 경우 추가 과정 스킵
			if(shortest.cost != d[shortest.v] || graph[shortest.v] == null) {
				continue;
			}

			// 현재 노드 to 인접 노드로 가는 거리가 더 짧은 경우 최단 거리 변경
			for(Node node : graph[shortest.v]) {
				if(shortest.cost + node.cost < d[node.v]) {
					d[node.v] = shortest.cost + node.cost;
					pq.add(new Node(node.v, d[node.v]));
				}
			}
		}


		// 결과 출력
		for(int i=1; i<=V; i++) {
			System.out.println(d[i] == Integer.MAX_VALUE ? "INF" : d[i]);
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

