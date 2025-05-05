import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		char[][] castle = new char[n][m];

		for(int i=0; i<n; i++) {
			castle[i] = br.readLine().trim().toCharArray();
		}

		// 보호가 필요한 행 개수
		int row = 0;
		for(int i=0; i<n; i++) {
			boolean isGuard = false;
			for(int j=0; j<m; j++) {
				if(castle[i][j] == 'X') {
					isGuard = true;
					break;
				}
			}
			if(!isGuard) {
				row+=1;
			}
		}

		// 보호가 필요한 열 개수
		int column = 0;
		for(int i=0; i<m; i++) {
			boolean isGuard = false;
			for(int j=0; j<n; j++) {
				if(castle[j][i] == 'X') {
					isGuard = true;
					break;
				}
			}
			if(!isGuard) {
				column+=1;
			}
		}
		bw.write(Math.max(row, column)+"\n");
		bw.close();
	}
}
