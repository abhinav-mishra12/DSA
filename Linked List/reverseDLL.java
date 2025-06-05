class Node {
    int data;
    Node next;
    Node back;

    Node(int data1, Node next1, Node back1){
        this.data = data1;
        this.back = back1;
        this.next = next1;
    }

    Node(int data1){
        this.data = data1;
        this.back = null;
        this.next = null;
    }
}
public class reverseDLL {
    public static void main(String[] args) {
        int[] arr = {2,5,8,7,9,5,3};
       //Convert ARR to DLL
       Node head = convertArr2DLL(arr);
       print(head);

       head = revDLL(head);
       print(head);
    }

    //Function to reverse the DLL
    public static Node revDLL(Node head){
    if (head == null || head.next == null) {
        return head;
    }

    Node current = head;
    Node temp = null;

    while (current != null) {
        // Swap next and back pointers
        temp = current.back;
        current.back = current.next;
        current.next = temp;

        // Move to the next node in original list (which is current.back now)
        current = current.back;
    }

    // After the loop, `temp` holds the last node we processed
    // So `temp.back` is the new head
    if (temp != null) {
        head = temp.back;
    }

    return head;
}


    //Function to print DLL
    public static void print(Node head){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    //Converting Array to Doubly Linked List
    public static Node convertArr2DLL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }
}
