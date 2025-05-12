// There is a singly-linked list head and we want to delete a node node in it.

// You are given the node to be deleted node. You will not be given access to the first node of head.

// All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.

// Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:

// The value of the given node should not exist in the linked list.
// The number of nodes in the linked list should decrease by one.
// All the values before node should be in the same order.
// All the values after node should be in the same order.
// Custom testing:

// For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
// We will build the linked list and pass the node to your function.
// The output will be the entire list after calling your function.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class deleteNodeInALinkedList {
    static class Solution {
        public void deleteNode(ListNode node) {
            if (node == null || node.next == null) {
                throw new IllegalArgumentException("Cannot delete the last node or a null node using this method");
            }
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        Solution sol = new Solution();
        sol.deleteNode(head.next); // delete node with value 5

        // Print the list to verify
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
