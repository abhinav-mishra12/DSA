// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

 

// Example 1:

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted linked list:
// 1->1->2->3->4->4->5->6
// Example 2:

// Input: lists = []
// Output: []
// Example 3:

// Input: lists = [[]]
// Output: []
import java.util.PriorityQueue;

public class mergeKSortedLists {
    public static void main(String[] args) {
        
 // Definition for singly-linked list.
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Min-heap with custom comparator to sort ListNodes by value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Add all non-null heads to the minHeap
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }

        // Dummy node to simplify result list creation
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        // Build the merged list
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll(); // get node with smallest value
            temp.next = node;               // add it to the result list
            temp = temp.next;               // move forward

            if (node.next != null) {
                minHeap.offer(node.next);   // push the next node from the same list
            }
        }

        return dummyNode.next;
    }
}

    }
}
