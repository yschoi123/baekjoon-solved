import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		int[] sumArray = new int[n+1];
		String[] nums = br.readLine().split(" ");
		for(int i=1; i<n+1; i++){
			int num = Integer.parseInt(nums[i-1]);
			sumArray[i] = sumArray[i-1] + num;
		}

		while(m-- > 0) {
			inputs = br.readLine().split(" ");
			int i = Integer.parseInt(inputs[0]);
			int j = Integer.parseInt(inputs[1]);

			bw.write((sumArray[j]-sumArray[i-1])+"\n");
		}
		bw.close();
	}

}
