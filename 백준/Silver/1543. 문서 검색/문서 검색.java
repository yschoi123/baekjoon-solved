
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String docs = sc.nextLine();
        String word = sc.nextLine();

        int count=0;
        int start = 0;
        while(start < docs.length()) {
            int foundIdx = docs.indexOf(word, start);
            if(foundIdx != -1) {
                count++;
                start = foundIdx + word.length();
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}
