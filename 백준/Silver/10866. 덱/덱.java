import java.util.*;

public class Main{

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();

        Dequeue dequeue = new Dequeue();

        while(n-- > 0) {
            String input = scanner.next();
            switch (input) {
                case "push_back":
                    int pushBackData = Integer.parseInt(scanner.next());
                    dequeue.pushBack(pushBackData);
                    break;
                case "push_front":
                    int pushFrontData = Integer.parseInt(scanner.next());
                    dequeue.pushFront(pushFrontData);
                    break;
                case "pop_front":
                    System.out.println(dequeue.popFront());
                    break;
                case "pop_back":
                    System.out.println(dequeue.popBack());
                    break;
                case "size":
                    System.out.println(dequeue.size());
                    break;
                case "empty":
                    System.out.println(dequeue.empty());
                    break;
                case "front":
                    System.out.println(dequeue.front());
                    break;
                case "back":
                    System.out.println(dequeue.back());
                    break;
            }
        }

    }

}

class Dequeue {
    public List<Integer> dequeue = new ArrayList<>();

    public void pushFront(int x) {
        dequeue.add(0, x);
    }

    public void pushBack(int x) {
        dequeue.add(x);
    }

    public int popFront() {
        return this.empty() == 1 ? -1 : dequeue.remove(0);
    }

    public int popBack() {

        return this.empty() == 1 ? -1 : dequeue.remove(this.size()-1);
    }

    public int empty() {
        return dequeue.isEmpty() ? 1: 0;
    }

    public int size() {
        return dequeue.size();
    }

    public int front() {
        return this.empty() == 1 ? -1 :dequeue.get(0);
    }

    public int back() {
        return this.empty() == 1 ? -1 :dequeue.get(this.size() - 1);
    }
}