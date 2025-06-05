class Node{
    int data;
    Node next;

    Node(int data1, Node next1){
        this.data = data1;
        this.next = next1;
    }

    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}

public class LL {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5};
        Node y = new Node(arr[0]);
        System.out.println(y.data);

        // //Convert arr to LL
        Node head = convertArr2LL(arr);
        System.out.println(head.data);

        //Traverse a linkedlist
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

        //Count the length of the LL
        int length = lengthOfLL(head);
        System.out.println("Length of the LinkedList: "+ length);

        //Searching in LL
        boolean ans = searchForAnElement(head, 6);
        System.out.println(ans);

    }

    //Function to search for an element
    private static boolean searchForAnElement(Node head, int value){
        Node temp = head;
        while (temp!=null) {
            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //Function to count the length of the LinkedList
    private static int lengthOfLL(Node head){
        int cnt = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }


    //Function to convert Array to LinkedList
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
