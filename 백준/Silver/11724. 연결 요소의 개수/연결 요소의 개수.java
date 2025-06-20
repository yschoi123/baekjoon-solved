import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Integer>[] graph = new LinkedList[n+1];

		for(int i=0; i<n+1; i++) {
			graph[i] = new LinkedList<>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(graph[a] == null) {
				graph[a] = new LinkedList<>();
			}
			if(graph[b] == null) {
				graph[b] = new LinkedList<>();
			}

			graph[a].add(b);
			graph[b].add(a);
		}

		int count = 0;
		boolean[] checked = new boolean[n+1];
		int root = -999;
		while((root = getNotChecked(checked)) != -1) {
			bfs(graph, checked, root);
			count += 1;
		}

		System.out.println(count);
	}


	static void bfs(List<Integer>[] graph, boolean[] checked, int v) {

		Deque<Integer> queue = new LinkedList<>();
		queue.addLast(v);
		checked[v] = true;
		
		while(!queue.isEmpty()) {
			int target = queue.pollFirst();
			for(int i=0; i<graph[target].size(); i++) {
				int near = graph[target].get(i);
				if(!checked[near]) {
					queue.addLast(near);
					checked[near] = true;
				}
			}
		}
	}

	static int getNotChecked(boolean[] checked) {
		for(int i=1; i<checked.length; i++) {
			if(!checked[i]) {
				return i;
			}
		}

		return -1;
	}

}