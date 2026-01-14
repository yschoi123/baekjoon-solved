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

		int[] counts = {0, 0, 0};
		for (int i = 0; i < answers.length; i++) {
			for(int j=0; j<humans.length; j++) {
				if (humans[j][i % humans[j].length] == answers[i]) {
					counts[j]++;
				}
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