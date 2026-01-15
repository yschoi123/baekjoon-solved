import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
       	int[][] losses = new int[N+1][2];

		for(int i=0; i<stages.length; i++) {
			int v = 1;
			// 도달한 플레이어 개수 추가
			while(v<stages[i]) {
				losses[v++][1]++;
			}

			// v 값이 N+1일 경우 모든 스테이지를 클리어 했음을 의미
			if(v == N+1) {
				continue;
			}

			// 도달은 했으나 클리어하지 못한 플레이어 수 추가
			losses[v][1]++;
			losses[v][0]++;
		}

		//  스테이지 별 실패율 계산
		Stage[] stageArr= new Stage[N];

		for(int i=1; i<=N; i++) {
			stageArr[i-1] = new Stage(i,  losses[i][1]!=0 ? (double)losses[i][0] / losses[i][1] : 0);
		}

		Arrays.sort(stageArr,(o1, o2)-> {
			if(o1.loss == o2.loss) {
				return Integer.compare(o1.num, o2.num);
			}
			return Double.compare(o2.loss, o1.loss);
		});


		int[] answer = new int[N];
		int i=0;
		for(Stage s: stageArr) {
			answer[i++] = s.num;
		}
		return answer;
    }
    
    class Stage{
		int num;
		double loss;

		Stage(int num, double loss) {
			this.num = num;
			this.loss = loss;
		}
	}
}