import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		while(t-- >0) {
			String[] inputs = br.readLine().split(" ");
			int h = Integer.parseInt(inputs[0]);
			int n = Integer.parseInt(inputs[2]);

			int roomNumber = (((n-1)%h) +1)*100 + (n-1)/h+1;
			bw.write(roomNumber + "\n");
		}
		bw.close();
	}

}
