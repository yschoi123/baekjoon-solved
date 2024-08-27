import java.util.*;

public class Main {
    static char[] stack = new char[51];
    static int p =  -1;

    static boolean isEmpty() {
        return p == -1;
    }
    static void push(char c) {
        p += 1;
        stack[p] = c;

    }

    static char pop() {

        if(isEmpty()) return ' ';

        char c = stack[p];
        p -= 1;
        return c;
    }

    static boolean isVPS(String ps) {

        p = -1;

        for(int i = 0; i < ps.length(); i++) {
            if(ps.charAt(i) == '(') {
                push('(');
            } else if(!isEmpty() && ps.charAt(i) == ')') {
                pop();
            } else {
                return false;
            }
        }

        return isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        while(n-- > 0) {
            String line = sc.nextLine();

            System.out.println(isVPS(line) ?  "YES": "NO");

        }
    }
}
