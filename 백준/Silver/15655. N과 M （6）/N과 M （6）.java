
import java.io.*;
import java.util.*;

public class Main {
    public static int[] array;
    public static boolean[] check;
    public static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        check = new boolean[n];
        res = new int[m];

        sequence(n, m, 0, 0);
    }

    public static void sequence(int n, int m, int size, int standard) {
       if(size == m) {
           for(int j=0; j<m; j++) {
               System.out.print(res[j]+" ");
           }
           System.out.println();
           return;
       }

       for(int i=0; i<n; i++) {
           if(!check[i] && array[i] > standard) {
               res[size] = array[i];
               check[i] = true;
               sequence(n, m, size+1, array[i]);
               check[i] = false;
           }
       }
    }
}
