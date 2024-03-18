import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[][] paper = new int[101][101];
        int n = sc.nextInt();

        while(n-- > 0) {
            int x= sc.nextInt();
            int y= sc.nextInt();

            for(int i=x; i< x+10; i++){
                for(int j=y; j<y+10; j++){
                    paper[i][j] = 1;
                }
            }
        }

        int area = 0;
        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++) {
                area += paper[i][j];
            }
        }
        System.out.print(area);
    }
}