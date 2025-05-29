
import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer>[] graph;
    public static int[] parents;
    public static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        parents = new int[n+1];
        check = new boolean[n+1];

        // 그래프 정보 저장
        while((n--)-1 > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(graph[a] == null) {
                graph[a] = new ArrayList<>();
            }

            if(graph[b] == null) {
                graph[b] = new ArrayList<>();
            }
            graph[a].add(b);
            graph[b].add(a);
        }

        // 1번 노드는 루트다
        check[1] = true;

        // 순회하며 부모 찾기
        findParent(1);

        // 부모 노드 출력
        for(int i = 2; i<parents.length ; i++) {
            System.out.println(parents[i]);
        }
    }

    public static void findParent(int node) {
        for(int i=0; i<graph[node].size(); i++) {
            int child = graph[node].get(i);
            if(!check[child]) {
                parents[child] = node;
                check[node] = true;
                findParent(child);
            }
        }
    }

}
