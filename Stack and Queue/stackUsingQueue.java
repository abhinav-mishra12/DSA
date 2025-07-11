import java.util.Queue;
import java.util.LinkedList;

class stUsingQueue{
    Queue<Integer> q = new LinkedList<>();

    public void push(int x){
        q.offer(x); // Step 1: Add new element to the rear
         // Step 2: Rotate the queue to move the new element to the front
        for (int i = 0; i < q.size() - 1; i++) {
            q.offer(q.poll());
        }
    }
    
    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.poll();  // Always removes the "top" of stack (front of queue)
    }

    public int top() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.peek();  // Looks at the "top" of stack (front of queue)
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public int size() {
        return q.size();
    }
}
public class stackUsingQueue {
    public static void main(String[] args) {
        stUsingQueue s = new stUsingQueue();
        s.push(10); // Queue: [10]
        s.push(20); // Queue after rotation: [20, 10]
        s.push(30); // Queue after rotation: [30, 20, 10]

        s.top(); // 30
        s.pop(); // removes 30
        s.top(); // 20

    }
}
