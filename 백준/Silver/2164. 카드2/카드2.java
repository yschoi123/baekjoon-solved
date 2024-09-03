

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> deque = new ArrayDeque<>();

        int n = sc.nextInt();
        for(int i=1; i<=n; i++) {
            deque.offerLast(i);
        }

        while(deque.size() > 1) {
            // 가장 앞 카드 버리기
            deque.pollFirst();

            // 그 다음 앞 카드를 가장 마지막으로 옮기기
            int i = deque.pollFirst();
            deque.offerLast(i);
        }

        System.out.println(deque.poll());
    }
}