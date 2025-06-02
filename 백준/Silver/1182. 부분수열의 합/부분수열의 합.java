
import java.io.*;
import java.util.*;

public class Main {
    static int s = 0;
    static int n = 0;
    static int[] array = null;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[n];
        for(int i=0; i<n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        solve(0, 0);
        bw.write(count+"\n");
        bw.close();
    }

    public static void solve(int sum, int index) {
        if(index == n) {
            return;
        }
        if((sum+array[index]) == s) {
            count += 1;
        }

        solve(sum + array[index], index+1);
        solve(sum, index + 1);

    }
}
