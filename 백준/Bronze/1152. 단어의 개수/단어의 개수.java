import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine().trim();
		if(input.isBlank()) {
			bw.write(0+"\n");
		} else {
			String[] words = input.split(" ");
			bw.write(words.length+"\n");
		}
		bw.close();
	}
}
