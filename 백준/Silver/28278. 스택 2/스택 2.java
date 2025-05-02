import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Deque<Integer> stack = new LinkedList<>();
		while(n-- > 0) {
			String[] inputs = br.readLine().split(" ");
			switch(inputs[0]) {
				case "1":
					stack.offerLast(Integer.parseInt(inputs[1]));
					break;
				case "2":
					Integer popData = stack.pollLast();
					bw.write((popData==null ? -1 : popData) + "\n");
					break;
				case "3":
					bw.write(stack.size() + "\n");
					break;
				case "4":
					bw.write((stack.isEmpty() ? 1 : 0)+"\n");
					break;
				case "5":
					Integer peekData = stack.peekLast();
					bw.write((peekData==null ? -1 : peekData) + "\n");
					break;
			}
		}
		bw.close();
	}
}
