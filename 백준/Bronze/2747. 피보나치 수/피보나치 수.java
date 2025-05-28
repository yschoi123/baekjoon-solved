
import java.io.*;
import java.util.*;

public class Main {
    public static int[] fibo = new int[45];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Arrays.fill(fibo, -1);
        fibo[0] = 0;
        fibo[1] = 1;
        System.out.println(fibonacci(n));

    }

    public static int fibonacci(int n) {
        if(n == 0) {
            return fibo[0];
        } else if(n == 1) {
            return fibo[1];
        }

        if(fibo[n-1] == -1) {
            fibo[n-1] = fibonacci(n-1);
        }

        if(fibo[n-2] == -1) {
            fibo[n-2] = fibonacci(n-2);
        }

        return fibo[n-1] + fibo[n-2];
    }
}
