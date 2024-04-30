import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.next();
        char[] charInput = input.toCharArray();
        
        char t = (char)('a' - 'A');
        
        for(int i=0; i<input.length(); i++) {
            if(charInput[i] >= 'a' && charInput[i] <= 'z') {
                charInput[i] = (char)(charInput[i] - t);
            } else if('A' <= charInput[i] && charInput[i] <= 'Z') {
                charInput[i] = (char)(charInput[i] + t);
            } 
        }
        
        String newStr = new String(charInput);
        System.out.print(newStr);
    }
}