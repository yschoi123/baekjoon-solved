
import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int n = 5;

       int sum = 0;
       int[] array = new int[n];
       for(int i=0; i<n; i++) {
           int num = Integer.parseInt(br.readLine());
           sum += num;
           array[i] = num;
       }

       Arrays.sort(array);

       bw.write((sum/n)+"\n");
       bw.write(array[2] + "\n");
       bw.close();
   }
}