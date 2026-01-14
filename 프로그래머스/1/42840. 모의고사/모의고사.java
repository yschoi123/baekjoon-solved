import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
// 수포자 정보 입력
		int[][] humans = {
			{1, 2, 3, 4, 5},
			{2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4 ,5, 5}
		};

		// 수포자별 정답 개수 세기
		int idx1 = 0;
		int idx2 = 0;
		int idx3 = 0;
		int[] counts = {0, 0, 0};

		for (int i = 0; i < answers.length; i++) {
			if (humans[0][(idx1++) % humans[0].length] == answers[i]) {
				counts[0]++;
			}
			if (humans[1][(idx2++) % humans[1].length] == answers[i]) {
				counts[1]++;
			}
			if (humans[2][(idx3++) % humans[2].length] == answers[i]) {
				counts[2]++;
			}
		}


		// 정답이 많은 수포자 찾기
		int max = counts[0];
		for(int c: counts) {
			max = Math.max(c, max);
		}

		List<Integer> list = new ArrayList<>();
		for(int i=0; i<counts.length; i++) {
			if(counts[i] == max) {
				list.add(i+1);
			}
		}

		int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
		return answer;
    }
}