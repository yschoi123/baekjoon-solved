import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();

		Integer rearData = null;
		while(n-- > 0) {
			String line =  br.readLine();
			switch(line.split(" ")[0]) {
				case "push":
					int data = Integer.parseInt(line.split(" ")[1]);
					queue.add(data);
					rearData = data;
					break;
				case "pop":
					Integer frontData = queue.poll();
					bw.write((frontData == null ? -1 : frontData) + "\n");
					if(queue.isEmpty()) {
						rearData = null;
					}
					break;
				case "size":
					bw.write((queue.size())+"\n");
					break;
				case "empty":
					bw.write((queue.isEmpty() ? 1 : 0)+"\n");
					break;
				case "front":
					bw.write((queue.peek() == null ? -1 : queue.peek())+"\n");
					break;
				case "back":
					bw.write((rearData == null	? -1 : rearData)+"\n");
			}

		}
		bw.close();
	}
}
