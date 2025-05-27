
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String str = null;
        while(!".".equals(str = br.readLine())) {
            bw.write((isBalanced(str) ? "yes" : "no") + "\n");
        }

        bw.close();
    }

    public static boolean isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if(c == '(' || c == '[') {
                stack.add(c);
            } else if(c==')') {
                Character popChar = stack.pollLast();
                if(popChar == null || popChar != '(') {
                    return false;
                }
            } else if(c == ']') {
                Character popChar = stack.pollLast();
                if(popChar == null || popChar != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
