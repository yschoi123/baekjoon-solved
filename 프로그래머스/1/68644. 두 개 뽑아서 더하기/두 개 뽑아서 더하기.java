import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
      	// 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 set에 저장
		TreeSet<Integer> set = new TreeSet<>();
		for(int i=0; i<numbers.length-1; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				set.add(numbers[i]+numbers[j]);
			}
		}


		int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
		return answer;
    }
}