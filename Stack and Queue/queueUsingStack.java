import java.util.Stack;

class QueueUsingStacks {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

   public void enqueue(int x) {
    inStack.push(x);
   }

   // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (outStack.isEmpty()) {
            // Transfer elements from inStack to outStack
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }

    // Peek front element
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.peek();
    }


    // Check if queue is empty
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // Get queue size
    public int size() {
        return inStack.size() + outStack.size();
    }
}
public class queueUsingStack {
    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front: " + q.front()); // 10
        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Front: " + q.front()); // 20
        System.out.println("Size: " + q.size());   // 2
        q.dequeue();
        q.dequeue();
        q.dequeue(); // Queue is empty
    }
}

