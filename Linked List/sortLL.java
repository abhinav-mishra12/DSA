// Given the head of a linked list, return the list after sorting it in ascending order.

 

// Example 1:


// Input: head = [4,2,1,3]
// Output: [1,2,3,4]
// Example 2:


// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]
// Example 3:

// Input: head = []
// Output: []

import java.util.Arrays;

public class sortLL {
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
    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        // Step 1: Count length
        int length = calculateLength(head);

        // Step 2: Copy values to array
        int[] arr = new int[length];
        ListNode temp = head;
        for (int i = 0; i < length; i++) {
            arr[i] = temp.val;
            temp = temp.next;
        }

        // Step 3: Sort the array
        Arrays.sort(arr);

        // Step 4: Write sorted values back to the linked list
        temp = head;
        for (int i = 0; i < length; i++) {
            temp.val = arr[i];
            temp = temp.next;
        }

        return head;
    }

    public int calculateLength(ListNode head) {
        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
}

    }
}
