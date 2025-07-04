public class deletion {
    public static void main(String[] args) {
        int[] arr = {3,5,8,7,6,5};
        Node head = convertArr2LL(arr);
        System.out.println(head.data);

        //Remove head
        head = removeHead(head);
        System.out.println("New head: "+ head.data);

        //Remove tail
        head = removeTail(head);
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

        //Remove Kth element from LL
        head = removeKthElement(head, 3);
        temp = head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();

        //Remove the element from the LL
        head = removeElement(head, 8);
        temp = head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }

    }

    //Delete the element from LL
    private static Node removeElement(Node head, int value){
        if (head==null) {
            return head;
        }
        if (head.data==value) {
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while (temp!=null) {
            if (temp.data==value) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    //Delete the Kth element of the linkedlist
    private static Node removeKthElement(Node head, int k){
        if (head==null) {
            return head;
        }
        if (k==1) {
            head = head.next;
            return head;
        }

        int count = 0;
        Node temp = head;
        Node prev = null;
        while (temp!=null) {
            count++;
            if (count==k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    //Delete the head of the linkedlist
    private static Node removeHead(Node head){
        if (head==null) {
            return head;
        }
        
        head = head.next;
        return head;
        
    }

    //Delete the tail
    private static Node removeTail(Node head){
        if (head.next == null || head==null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next!=null) {
            temp = temp.next;
        }
        temp.next=null;
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
