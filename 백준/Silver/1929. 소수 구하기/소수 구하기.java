import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean[] prime = new boolean[n+1];
        for(int i=0; i<prime.length; i++) {
            prime[i] = true;
        }
        prime[0] = false;
        prime[1] = false;

        for(int i=2; i<prime.length; i++) {
            for(int j=i; j<=n/i; j++) {
                if(i*j < prime.length) {
                    prime[i*j] = false;
                }
            }
        }

        for(int i=m; i<=n; i++) {
            if(prime[i]) {
                System.out.println(i);
            }
        }
    }
}