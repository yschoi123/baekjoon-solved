import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
			String input = br.readLine();
			if(input == null || input.isBlank() || input.isEmpty()) {
				break;
			}
			bw.write(input+"\n");
		}
		bw.close();
	}
}
