// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

// Example 1:


// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]
// Example 2:


// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]
public class reverseNodesInkGroup {
    public static void main(String[] args) {
        /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;

        while (temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            // Reverse current k-group
            ListNode reversedHead = reverse(temp);

            // Connect previous group to reversed head
            if (temp == head) {
                head = reversedHead;
            } else {
                prevNode.next = reversedHead;
            }

            prevNode = temp; // after reversal, temp becomes end of reversed group
            temp = nextNode;
        }

        return head;
    }

    private ListNode findKthNode(ListNode node, int k) {
        while (node != null && k > 1) {
            node = node.next;
            k--;
        }
        return node;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}

    }
}
