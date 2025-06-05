public class insertion {
    public static void main(String[] args) {
        int[] arr = {3,5,8,7,6,5};
        Node head = convertArr2LL(arr);
        System.out.println(head.data);

        //Insert at the head
        head = insertHead(head, 9);
        System.out.println(head.data);

        //Insert at the end
        head = insertLast(head, 1);
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+ "  ");
            temp=temp.next;
        }
        System.out.println();

        //Insert at the given Kth element
        head = insertAtKthElement(head, 4, 67);
        temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

        //Insert the element before the value x
        head = insertElement(head, 79, 6);
        temp = head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    //Insert the element before the value x
    private static Node insertElement(Node head, int el, int value){
        if (head==null) {
            return null;
        }
        if (head.data==value) {
            return new Node(el, head);
        }
        Node temp = head;
        while (temp.next!=null) {
            if (temp.next.data==value) {
                Node x = new Node(el, temp.next);
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        
        return head;
    }

    //Insert the Kth element of the linkedlist
    private static Node insertAtKthElement(Node head, int k, int value){
        if (head==null) {
            if (k==1) {
                return new Node(value);
            }
        }

        if (k==1) {
            Node temp = new Node(value, head);
            return temp;
        }

        int cnt = 0;
        Node temp = head;
        while (temp!=null) {
            cnt++;
            if (cnt==k-1) {
                Node x = new Node(value);
                x.next = temp.next;
                temp.next=x;
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    //Insert at the head of the linkedlist
    private static Node insertHead(Node head, int value){
        Node temp = new Node(value, head);
        return temp;
    }

    //Insert at the last of the LL
    private static Node insertLast(Node head, int value){
        if (head==null) {
            return new Node(value);
        }
        Node temp = head;
        while (temp.next!=null) {
            temp = temp.next;
        }
        temp.next = new Node(value);
        return head;
    }

    private static Node convertArr2LL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
}
