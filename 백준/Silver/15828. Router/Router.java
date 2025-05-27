
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int input = -999;
        while((input = Integer.parseInt(br.readLine())) != -1) {
            if(queue.size() >= n) {
                continue;
            }

            if(input == 0) {
                queue.poll();
            } else {
                queue.add(input);
            }
        }

        while(!queue.isEmpty()) {
            bw.write(queue.poll()+" ");
        }
        bw.write("\n");
        bw.close();

    }
}
