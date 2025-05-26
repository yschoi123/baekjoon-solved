
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        String str = br.readLine();
        int m = Integer.parseInt(br.readLine());
        int cursor = str.length();
        DoubleLinkedList list = new DoubleLinkedList();
        for (char c : str.toCharArray()) {
            list.addCursor(c);
        }

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "L":
                    list.cursorMoveLeft();
                    break;
                case "D":
                    list.cursorMoveRight();
                    break;
                case "B":
                    list.removeCursor();
                    break;
                case "P":
                    char ch = st.nextToken().charAt(0);
                    list.addCursor(ch);
            }
        }

        bw.write(list.getString() + "\n");
        bw.close();
    }
}

class DoubleLinkedList {
    Node first = null;
    Node end = null;
    Node cursor = null;
    int size = 0;

    public DoubleLinkedList() {
        Node node = new Node(' ');
        cursor = node;
        first = node;
        end = node;
    }

    void cursorMoveLeft() {
        if(cursor == first) {
            return;
        }
        cursor = cursor.prev;
    }

    void cursorMoveRight() {
        if(cursor == end) {
            return;
        }
        cursor = cursor.next;
    }

    void removeCursor() {
        if(cursor == first) {
            return;
        }

        Node del = cursor.prev;
        if(del.prev != null) {
           del.prev.next = cursor;
           cursor.prev = del.prev;
        } else {
            first = cursor;
            cursor.prev = null;
        }
        size--;

    }

    void addCursor(char c) {

        Node newNode = new Node(c);
        Node prev = cursor.prev;
        if(prev!= null) {
            prev.next = newNode;
            newNode.prev = prev;
        } else {
            first = newNode;
        }
        newNode.next = cursor;
        cursor.prev = newNode;
        size++;
    }

    String getString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node p = first;
        while(p.c != ' ') {
            stringBuilder.append(p.c);
            p = p.next;
        }
        return stringBuilder.toString();
    }
}

class Node {
    char c;
    Node next;
    Node prev;

    public Node(char c) {
        this.c = c;
    }
}