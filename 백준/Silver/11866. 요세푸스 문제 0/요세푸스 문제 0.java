import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input.split(" ")[0]);
		int k = Integer.parseInt(input.split(" ")[1]);

		CircleQueue<Integer> queue = new CircleQueue<>();
		for(int i=1; i<=n; i++) {
			queue.enqueue(i);
		}

		String output = "<";
		while(!queue.isEmpty()) {
			output += queue.josephus(k)+(queue.isEmpty() ? "": ", ");
		}
		output += ">";
		System.out.println(output);
	}


}
class CircleQueue<E> {
	int size = 0;
	Node<E> front = null;
	Node<E> rear = null;

	public boolean isEmpty() {
		return size == 0;
	}

	public void enqueue(E data) {
		Node<E> newNode = new Node<>(data);
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			size++;
			return;
		}

		newNode.prev = rear;
		rear.next = newNode;
		rear = newNode;
		front.prev = newNode;
		newNode.next = front;
		size++;
	}

	public E josephus(int k) {
		if(isEmpty()) {
			return null;
		}

		if(size == 1) {
			E data =  front.data;
			front = null;
			rear = null;
			size--;
			return data;
		}

		Node<E> temp = front;
		for(int i=0; i<k-1; i++) {
			temp = temp.next;
		}
		E data = temp.data;
		front = temp.next;
		rear = temp.prev;
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		size--;
		return data;
	}
}

class Node<E> {
	E data;
	Node<E> next;
	Node<E> prev;

	public Node(E data) {
		this.data = data;
	}
}