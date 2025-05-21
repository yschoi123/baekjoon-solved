
import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       String[] inputs = br.readLine().split(" ");
       int n = Integer.parseInt(inputs[0]);
       int m = Integer.parseInt(inputs[1]);

       Set<String> strings = new HashSet<>();

       while(n-- > 0) {
           strings.add(br.readLine());
       }

       int count = 0;
       while(m-- > 0) {
           if(strings.contains(br.readLine())) {
               count += 1;
           }
       }

       bw.write(count + " \n");
       bw.close();
   }
}