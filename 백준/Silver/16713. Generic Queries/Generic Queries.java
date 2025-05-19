import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int q = Integer.parseInt(inputs[1]);

		int[] xorArray = new  int[n+1];
		String[] nums = br.readLine().split(" ");
		for(int i=1; i<n+1; i++){
			int num = Integer.parseInt(nums[i-1]);
			xorArray[i] = xorArray[i-1] ^ num;
		}

		int xor = 0;
		while(q-- > 0) {
			inputs = br.readLine().split(" ");
			int i = Integer.parseInt(inputs[0]);
			int j = Integer.parseInt(inputs[1]);


			xor ^= (xorArray[j] ^ xorArray[i - 1]);
		}

		bw.write(xor +"\n");
		bw.close();
	}

}
