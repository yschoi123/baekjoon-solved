import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = 9;
		int max = 7;
		int[] fake = new int[n];
		for(int i=0; i<n; i++){
			fake[i] = sc.nextInt();
		}

		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {

				int[] real = new int[max];
				int index = 0;
				int sum = 0;
				for(int k=0; k<n; k++) {
					if(k == i ||  k == j) {
						continue;
					}
					real[index++] = fake[k];
					sum += fake[k];
				}

				if(sum == 100) {
					Arrays.sort(real);
					for(int p=0; p<max; p++) {
						System.out.println(real[p]);
					}
					return;
				}
			}
		}


	}

}
