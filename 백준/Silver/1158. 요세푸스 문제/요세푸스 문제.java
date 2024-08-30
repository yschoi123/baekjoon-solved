
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        DoubleLinkedList list = new DoubleLinkedList();
        for(int i=1; i<=n; i++) {
            list.add(i);
        }

        int p = 1;
        Node c_node = list.head;
        System.out.print("<");
        while(list.head != null) {
            c_node = c_node.next;
            if(p == k) {
                int v = list.remove(c_node.prev);
                p = 1;
                System.out.print(v+(list.head!=null ? ", " : ""));
                continue;
            }
            p++;
        }
        System.out.println(">");
    }
}

class DoubleLinkedList {
    Node head;

    void add(int v) {
        Node newNode = new Node(v);
        if(head == null) {
            head = newNode;
            head.prev = newNode;
            head.next = newNode;
            return;
        }

        Node temp = head.prev;
        temp.next = newNode;
        newNode.prev = temp;

        newNode.next = head;
        head.prev = newNode;
    }

    int remove(Node target) {

        if(target == head) {
            head = head.next;
        }

        int v = target.value;
        if(target.next== target) {
            head = null;
        } else {
            Node prev = target.prev;
            prev.next = target.next;
            prev.next.prev = prev;
        }
        return v;
    }


}

class Node {
    int value;
    Node next;
    Node prev;

    Node() {}
    Node(int value) {
        this.value = value;
    }
}
