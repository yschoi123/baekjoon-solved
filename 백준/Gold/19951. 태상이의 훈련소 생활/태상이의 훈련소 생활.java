import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		int[] nums = new int[n];
		String[] numStrings = br.readLine().split(" ");
		for(int i=0; i<n; i++){
			nums[i] = Integer.parseInt(numStrings[i]);
		}


		int[] delta = new int[n];
		while(m-- > 0) {
			inputs = br.readLine().split(" ");
			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);
			int k = Integer.parseInt(inputs[2]);

			delta[a-1] += k;
			if(b < n) {
				delta[b] -= k;
			}
		}


		int accDelta = 0;
		for(int i =0; i<n; i++) {
			if(delta[i]!= 0) {
				accDelta += delta[i];
			}
			nums[i] += accDelta;
			bw.write(nums[i] +" ");
		}
		bw.write("\n");
		bw.close();
	}

}
