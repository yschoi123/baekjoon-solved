
import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int n = Integer.parseInt(br.readLine());
       Set<Integer> nums = new HashSet<>();
       for (int i = 0; i < n; i++) {
           nums.add(Integer.parseInt(br.readLine()));
       }

       Set<Integer> sums = new HashSet<>();
       for (int num1 : nums) {
           for (int num2 : nums) {
               sums.add(num1 + num2);
           }
       }

       int result = -1;
       for (int k : nums) {
           for (int z : nums) {
               if (sums.contains(k - z)) {
                   result = Math.max( k, result);
               }
           }
       }

       bw.write(result + "\n");
       bw.close();
   }
}