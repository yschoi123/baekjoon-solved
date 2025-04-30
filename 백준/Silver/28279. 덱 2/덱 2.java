import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Deque deque = new Deque();

		while(n-- > 0) {
			String[] inputs = br.readLine().split(" ");
			int inst = Integer.parseInt(inputs[0]);
			int x = (inst == 1 || inst == 2) ? Integer.parseInt(inputs[1]) : -1;

			switch(inst) {
				case 1:
					deque.addFirst(x);
					break;
				case 2:
					deque.addLast(x);
					break;
				case 3:
					bw.write(deque.removeFirst() + "\n");
					break;
				case 4:
					bw.write(deque.removeLast() + "\n");
					break;
				case 5:
					bw.write(deque.getSize() + "\n");
					break;
				case 6:
					bw.write((deque.isEmpty() ? 1 : 0) + "\n");
					break;
				case 7:
					bw.write(deque.peekFirst() + "\n");
					break;
				case 8:
					bw.write(deque.peekLast() + "\n");
			}
		}
		bw.close();

	}
}

class Deque {
	private int size;
	private Node front;
	private Node rear;

	void addFirst(int data) {
		Node newNode = new Node(data);

		if(isEmpty()) {
			rear = newNode;
		} else {
			front.prev = newNode;
			newNode.next = front;
		}

		front = newNode;
		size += 1;
	}

	void addLast(int data) {
		Node newNode = new Node(data);

		if(isEmpty()) {
			front = newNode;
		} else {
			rear.next = newNode;
			newNode.prev = rear;
		}

		rear = newNode;
		size += 1;
	}

	int removeFirst() {
		if(isEmpty()) {
			return -1;
		}

		int data = front.data;
		front = front.next;

		if(front != null) {
			front.prev.next = front.prev = null;
		}

		size -= 1;

		return data;
	}

	int removeLast() {
		if(isEmpty()) {
			return -1;
		}

		int data = rear.data;
		rear = rear.prev;

		if(rear != null) {
			rear.next.prev = rear.next = null;
		}

		size -= 1;

		return data;
	}

	int getSize() {
		return size;
	}

	boolean isEmpty() {
		return size == 0;
	}

	int peekFirst() {
		if(isEmpty()) {
			return -1;
		}

		return front.data;
	}

	int peekLast() {
		if(isEmpty()) {
			return -1;
		}

		return rear.data;
	}


}

class Node {
	int  data;
	Node prev;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}
