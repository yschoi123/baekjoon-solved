import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int row = 0;
        int column = 0;
        int maxVal = -1;
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                int value = sc.nextInt();
                
                if(value > maxVal) {
                    maxVal = value;
                    row = i+1;
                    column = j+1;
                }
            }
        }
        
        System.out.println(maxVal);
        System.out.print(row+" "+column);
    }
}