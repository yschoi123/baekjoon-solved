import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        int sLen = s.length();
        for(int i=0; i<sLen/2; i++){
            if(s.charAt(i) != s.charAt(sLen-i-1)){
                System.out.print(0);
                return;
            }
        }
        System.out.print(1);
    }
}