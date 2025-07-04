// Given the head of a singly linked list, return the middle node of the linked list.

// If there are two middle nodes, return the second middle node.

 

// Example 1:


// Input: head = [1,2,3,4,5]
// Output: [3,4,5]
// Explanation: The middle node of the list is node 3.
// Example 2:


// Input: head = [1,2,3,4,5,6]
// Output: [4,5,6]
// Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

public class middleOfTheLinkedList{
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
    public ListNode middleNode(ListNode head) {
        int length = countLengthOfLL(head);
        int middle = (length/2)+1;
        for(int i = 1; i < middle; i++){
            head = head.next;
        }
        return head;

    }

    public int countLengthOfLL(ListNode head){
        ListNode temp = head;
        int cnt = 0;
        while(temp!=null){
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }
}
    }
}