class Node {
    int data;
    Node next;

    Node() {}

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

class Queue {
    int size = 0;
    Node start = null; // front of the queue
    Node end = null;   // rear of the queue

    public void push(int x) {
        Node temp = new Node(x);
        if (start == null) {
            start = end = temp;
        } else {
            end.next = temp;
            end = temp;
        }
        size++;
    }

    public void pop() {
        if (start == null) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = start;
        start = start.next;
        temp.next = null;
        size--;

        if (start == null) {
            end = null; // reset end when queue becomes empty
        }
    }

    public int top() {
        if (start == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return start.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class queueUsingLL {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.push(10);
        q.push(20);
        q.push(30);

        System.out.println("Top: " + q.top());    // 10
        System.out.println("Size: " + q.size());  // 3

        q.pop();
        System.out.println("Top after pop: " + q.top()); // 20
        System.out.println("Size after pop: " + q.size()); // 2

        q.pop();
        q.pop();
        q.pop(); // Queue is empty
    }
}
