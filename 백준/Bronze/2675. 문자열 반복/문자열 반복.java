import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		while(n-- > 0) {
			String[] inputs = br.readLine().split(" ");
			int count = Integer.parseInt(inputs[0]);
			String s = inputs[1];

			for (char c : s.toCharArray()) {
				for(int i=0; i< count; i++) {
					bw.write(c);
				}
			}
			bw.write("\n");
		}
		bw.close();
	}
}
