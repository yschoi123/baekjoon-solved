
import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       long n = Long.parseLong(br.readLine());
       bw.write(search(n, 0, n) + "\n");
       bw.close();
   }

   public static long search(long target, long left, long right) {

       long result = right;
       while(left <= right) {
           long m = (left + right) / 2;
           if(condition(m, target)) {
               result = Math.min(m, result);
               right = m - 1;
           } else {
               left = m +1;
           }
       }

       return result;
   }

   public static boolean condition(long q, long n) {
       return Math.pow(q, 2) >= n;
   }
}