class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

class Stack {
    Node top;
    int size = 0;

    public void push(int x) {
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
        size++;
    }

    public void pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;
        size--;
    }

    public int top() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1; // or throw exception
        }
        return top.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }
}


public class stackUsingLL {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        System.out.println("Top: " + s.top()); // 20
        s.pop();
        System.out.println("Top after pop: " + s.top()); // 10
        System.out.println("Size: " + s.size()); // 1
        s.pop();
        s.pop(); // Stack is empty
    }
}
