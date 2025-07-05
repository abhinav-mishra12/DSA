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
        if(head==null || k==1){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGrpEnd = dummy;
        ListNode curr = head;

        while(hasKNodes(curr, k)){
            //Reverse K nodes
            ListNode prev = null;
            ListNode tail = curr;

            for(int i=0; i<k; i++){
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            // Connect previous group to new head (prev), and tail to remaining list
            prevGrpEnd.next = prev;
            tail.next = curr;

            // Move prevGroupEnd to tail for next group
            prevGrpEnd = tail;

        }

        return dummy.next;


    }

    
    // Helper function to check if k nodes remain

    public boolean hasKNodes(ListNode node, int k){
        int cnt = 0;
        while(node!=null && cnt<k){
            node = node.next;
            cnt++;
        }

        if(cnt==k){
            return true;
        }

        return false;
    }
}
    }
}
