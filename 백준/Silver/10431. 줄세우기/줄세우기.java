import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int len = 20;
		int n = sc.nextInt();
		
		while(n-- > 0) {
			int num = sc.nextInt();
			int stepback = 0;
			int[] students = new int[len];
			int index = -1;

			// 첫번째 학생 추가
			students[++index] = sc.nextInt();

			// 두번째 학생부터 줄서기
			for(int t=1; t<len; t++) {
				students[++index] = sc.nextInt();
				for(int i=index; i>0; i--) {
					if(students[i] > students[i-1]) {
						break;
					}

					int temp = students[i];
					students[i] = students[i-1];
					students[i-1] = temp;
					stepback += 1;
				}
			}
			System.out.println(num + " " + stepback);
		}
	}

}
