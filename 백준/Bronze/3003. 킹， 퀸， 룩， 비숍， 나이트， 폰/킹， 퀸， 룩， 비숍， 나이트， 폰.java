import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        
        int[] fixs = {1, 1, 2, 2, 2, 8};
        for(int i=0; i<6; i++){
            int num = scanner.nextInt();
            System.out.print((fixs[i]-num)+" ");
        }
    }
}