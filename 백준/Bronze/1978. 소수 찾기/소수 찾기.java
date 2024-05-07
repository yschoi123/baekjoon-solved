
import java.util.Scanner;
public class Main {
    public static boolean isPrime(int num) {
        if(num <= 1) {
            return false;
        }
        for(int i=2; i<num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        while(n-- > 0) {
            int input = sc.nextInt();
            if(isPrime(input)) {
                count++;
            }
        }

        System.out.print(count);
    }
}
