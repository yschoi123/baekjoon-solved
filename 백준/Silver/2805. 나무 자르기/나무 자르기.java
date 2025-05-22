
import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       String[] inputs = br.readLine().split(" ");
       int n = Integer.parseInt(inputs[0]);
       int m = Integer.parseInt(inputs[1]);
       int[] trees = new int[n];
       inputs = br.readLine().split(" ");
       for (int i = 0; i < n; i++) {
           trees[i] = Integer.parseInt(inputs[i]);
       }

       bw.write(search(trees, m, 0, 2000000000) + "\n");
       bw.close();
   }

   public static long search(int[] array, int target, long start, long end) {

       long result = start;
       while(start <= end) {

           long m = (start + end )/ 2;
           long sum = 0;
           for(int i=0; i<array.length; i++) {
               long remained =array[i] - m;
               sum += Math.max(remained, 0);
           }
           if(condition(sum, target)) {
               result = Math.max(result, m);
               start = m + 1;
           } else {
               end = m - 1;
           }
       }

       return result;
   }

   public static boolean condition(long a, long b) {
       return a >= b;
   }
}