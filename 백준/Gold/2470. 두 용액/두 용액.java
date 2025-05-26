
import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       StringTokenizer st = new StringTokenizer(br.readLine(), " ");

       // 입력 값 받기
       int n = Integer.parseInt(st.nextToken());
       int[] nums = new int[n];

       st = new StringTokenizer(br.readLine(), " ");
       for(int i=0; i<n; i++) {
           nums[i] = Integer.parseInt(st.nextToken());
       }

       Arrays.sort(nums);
       int left = 0;
       int right = n-1;

       int min = Integer.MAX_VALUE;
       int a = 0;
       int b = 0;
       while(left < right) {
           int mix = nums[left] + nums[right];
           if (min > Math.abs(mix)) {
               min = Math.abs(mix);
               a = nums[left];
               b = nums[right];
           }

           if(mix < 0) {
               left += 1;
           } else if(mix > 0) {
               right -= 1;
           } else {
               break;
           }

       }
       bw.write(a+" "+b+"\n");
       bw.close();
   }
}