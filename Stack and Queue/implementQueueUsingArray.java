class Queue {
    int size = 10;
    int[] queue = new int[size];
    int start = -1;
    int end = -1;
    int currentSize = 0;

    public void push(int x) {
        if (currentSize == size) {
            System.out.println("Queue is full");
            return;
        }

        if (currentSize == 0) {
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % size;
        }

        queue[end] = x;
        currentSize++;
    }

    public int pop() {
        if (currentSize == 0) {
            System.out.println("Queue is empty");
            return -1; // or throw exception
        }

        int el = queue[start];

        if (currentSize == 1) {
            start = end = -1;
        } else {
            start = (start + 1) % size;
        }

        currentSize--;
        return el;
    }

    public int top() {
        if (currentSize == 0) {
            System.out.println("Queue is empty");
            return -1; // or throw exception
        }

        return queue[start];
    }

    public int size() {
        return currentSize;
    }
}

public class implementQueueUsingArray {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.push(4);
        q.push(2);
        q.push(56);
        System.out.println(q.top());   // Output: 4
        System.out.println(q.size());  // Output: 3
        q.pop();
        q.pop();
        q.push(56);
        System.out.println(q.size());  // Output: 2
        System.out.println(q.top());   // Output: 56
    }
}

