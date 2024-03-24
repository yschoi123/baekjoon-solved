import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); 
        int m = sc.nextInt();
        
        int[] basket = new int[n];
        while(m-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            for( ; i<=j; i++) {
                basket[i-1] = k;
            }
        }
        
        for(int i=0; i<n; i++) {
            System.out.print(basket[i]+" ");
        }
    }
}