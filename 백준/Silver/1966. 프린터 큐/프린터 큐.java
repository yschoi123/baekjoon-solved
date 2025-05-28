
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        while(t-- >0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;
            
            st = new StringTokenizer(br.readLine());
            LinkedList<Integer> queue = new LinkedList<>();
            for(int i=0; i<n; i++) {
                int primary = Integer.parseInt(st.nextToken());
                queue.add((i== m) ? primary+10 : primary);
            }

            while(!queue.isEmpty()) {
                if(hasMorePrimaryThenFirst(queue)) {
                    int first = queue.pollFirst();
                    queue.addLast(first);
                    continue;
                }
                int first = queue.pollFirst();
                count++;
                if(first > 10) {
                    bw.write(count + "\n");
                    break;
                }

            }
        }
        bw.close();

    }

    public static boolean hasMorePrimaryThenFirst(LinkedList<Integer> list) {
        int target = list.get(0);
        if(target > 10) {
            target -= 10;
        }
        for(int i =1; i<list.size(); i++) {
            int e = list.get(i);
            e = (e > 10) ? (e-10) : e;
            if(target < e) {
                return true;
            }
        }
        return false;
    }
}
