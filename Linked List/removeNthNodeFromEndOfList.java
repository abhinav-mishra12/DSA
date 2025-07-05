// Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

// Example 1:


// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:

// Input: head = [1], n = 1
// Output: []
// Example 3:

// Input: head = [1,2], n = 1
// Output: [1]
public class removeNthNodeFromEndOfList {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }
        
        if(n==1){
            ListNode headd = removeTail(head);
            return headd;
        }

        int length = calculateLength(head);
        int k = length-n;
        // If the node to remove is the head
        if (k == 0) {
            return head.next;
        }

        ListNode tempo = head;
        int count = 0;
        while(tempo!=null){
            count++;
            if(count==k){
                tempo.next = tempo.next.next;
                break;
            }
            tempo = tempo.next;
        }

        return head;
        


    }

    public int calculateLength(ListNode head){
        ListNode temp = head;
        int cnt = 0;
        while(temp!=null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    public  ListNode removeTail(ListNode head){
        if (head.next == null || head==null) {
            return null;
        }
        ListNode temp = head;
        while (temp.next.next!=null) {
            temp = temp.next;
        }
        temp.next=null;
        return head;
    }
}
    }
}
