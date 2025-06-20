import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		List<Integer>[] graph = new LinkedList[n+1];

		for(int i=0; i<n+1; i++) {
			graph[i] = new LinkedList<>();
		}

		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}


		boolean[] checked = new boolean[n+1];
		int count =	bfs(graph, checked, 1);

		System.out.println(count);
	}


	static int bfs(List<Integer>[] graph, boolean[] checked, int v) {

		Deque<Integer> queue = new LinkedList<>();
		queue.addLast(v);
		checked[v] = true;

		int count =0;
		while(!queue.isEmpty()) {
			int target = queue.pollFirst();
			for(int i=0; i<graph[target].size(); i++) {
				int near = graph[target].get(i);
				if(!checked[near]) {
					queue.addLast(near);
					checked[near] = true;
					count +=1;
				}
			}
		}
		return count;
	}


}