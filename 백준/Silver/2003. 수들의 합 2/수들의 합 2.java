
import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       StringTokenizer st = new StringTokenizer(br.readLine(), " ");

       // 입력 값 받기
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       int[] nums = new int[n];

       st = new StringTokenizer(br.readLine(), " ");
       for(int i=0; i<n; i++) {
           nums[i] = Integer.parseInt(st.nextToken());
       }

       // 경우의 수 구하기
       int count = 0;
       int sum = nums[0];
       for (int i = 0, j = 1; i < n; i++) {
           while(j<n && sum+nums[j] <= m) {
               sum += nums[j++];
           }

           if(sum == m) {
               count += 1;
           }

           sum -= nums[i];
       }

       bw.write(count + "\n");
       bw.close();
   }
}