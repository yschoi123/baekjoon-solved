
import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] graph;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 인접 행렬로 그래프 표현
        graph = new boolean[n+1][n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = true;
            graph[b][a] = true;
        }


        boolean[] isVisited = new boolean[n+1];
        dfs(isVisited, v);
        System.out.println();
        bfs(v);
    }

    static void dfs(boolean[] isVisited, int v) {
        // 현재 노드 방문 처리
        isVisited[v] = true;
        System.out.print(v +" ");
        // 인접 노드 탐색
        for(int i=1; i<n+1; i++) {
            if(graph[v][i] && !isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    static void bfs(int v) {

        Deque<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n+1];
        queue.addLast(v);
        isVisited[v]= true;

        while(!queue.isEmpty()) {
            // 맨 앞에 있는 노드(탐색 대상) 가져오기
            int target = queue.pollFirst();

            System.out.print(target +" ");

            // 인접 노드 탐색 후 큐에 넣기
            for(int i=1; i<n+1; i++) {
                if(graph[target][i] && !isVisited[i]) {
                    queue.addLast(i);
                    isVisited[i] = true;
                }
            }

        }
    }

}
