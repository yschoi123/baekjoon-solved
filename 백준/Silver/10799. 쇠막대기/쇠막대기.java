
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] array = br.readLine().toCharArray();

        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        for(int i = 0, j=1; i<array.length; i++, j++) {
            if(j<array.length && array[i]=='(' && array[j]==')') {
                count += stack.size();
                i+=1;
                j+=1;
            } else if(array[i] == ')') {
                count += 1;
                stack.pollLast();
            } else if(array[i] == '(') {
                stack.add('(');
            }
        }
        bw.write(count+"\n");
        bw.close();
    }
}
