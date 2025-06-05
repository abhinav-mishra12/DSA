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
    public class DLL {
    public static void main(String[] args) {
       int[] arr = {2,5,8,7,9,5,3};

       //Convert ARR to DLL
       Node head = convertArr2DLL(arr);
       print(head);

       //Delete head of the DLL
       head = deleteHead(head);
       print(head);

       //Delete tail of the DLL
       head = deleteTail(head);
       print(head);

       //Delete the Kth element of the DLL
       head = deleteKthElement(head, 3);
       print(head);

       //Remove the Given Node
       head = removeNode(head, 9);
       print(head);

       //Insert at the head position
       head = insertHead(head, 9);
       print(head);

       //Insert at the tail position
       head = insertTail(head, 1);
       print(head);

       //Insert at Kth position of the LinkedList
       head = insertAtKthPosition(head, 4, 12);
       print(head);

    //    //Insert a Node
    //    insertAtNode(5, 64);
    //    print(head);

    }

    //Function to insert node before element
    public static void insertATNode(Node ele, int value){
        Node prev = ele.back;
        Node newNode = new Node(value, ele, prev);
        prev.next = newNode;
        ele.back = newNode;

    }

    //Function to delete the Kth element of the DLL
    public static Node insertAtKthPosition(Node head, int k, int value){
        if (head==null) {
            return null;
        }
        if (k==1) {
            return insertHead(head, value);
        }
        int cnt = 0;
        Node temp = head;        
        while (temp!=null) {
            cnt++;
            if (cnt==k) {
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        Node newNode = new Node(value, temp, prev);
        prev.next = newNode;
        temp.back = newNode;  
        return head;
    }

    //Function to Insert a Node at the tail
    public static Node insertTail(Node head, int value){
        Node tail = head;
        while (tail.next!=null) {
            tail=tail.next;
        }
        
        Node newNode = new Node(value, null, tail);
        tail.next = newNode;
        
        return head;
    }

    //Function to Insert a Node at the head
    public static Node insertHead(Node head, int value){
        Node newHead = new Node(value, head, null);
        head.back=newHead;
        head = newHead;
        return head;
    }

    //Function to Remove the element from the DLL
    public static Node removeNode(Node head, int value){
        Node temp = head;
        while (temp.data!=value) {
            temp = temp.next;
        }
        Node front = temp.next;
        Node prev = temp.back;
        if (front==null) {
            prev.next=null;
            return head;
        }
        prev.next=front;
        front.back=prev;
        temp.next=null;
        temp.back=null;
        return head;
    }

    //Function to delete the Kth element of the DLL
    public static Node deleteKthElement(Node head, int k){
        if (head==null) {
            return null;
        }
        int cnt = 0;
        Node temp = head;        
        while (temp!=null) {
            cnt++;
            if (cnt==k) {
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        Node front = temp.next;
        if (prev==null && front==null) {
            return null;
        }
        else if (prev==null) {
            head = head.next;
            return head;
        }
        else if(front==null){
            prev.next = null;

        }
        prev.next=front;
        front.back=prev;
        temp.next=null;
        temp.back=null;
        return head;
    }

    //Function to delete tail of the DLL
    public static Node deleteTail(Node head){
        if (head==null || head.next==null) {
            return null;
        }
        Node tail = head;
        while (tail.next!=null) {
            tail = tail.next;
        }
        Node prev = tail.back;
        tail.back = null;
        prev.next = null;

        return head;
    }

    //Function to delete head of the DLL
    public static Node deleteHead(Node head){
        if (head==null || head.next==null) {
            return null;
        }
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
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
