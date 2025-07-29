// Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

// Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

 

// Example 1:

// Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
// Output: true
// Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
// Example 2:

// Input: hand = [1,2,3,4,5], groupSize = 4
// Output: false
// Explanation: Alice's hand can not be rearranged into groups of 4.
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class handOfStraights {
    public static void main(String[] args) {

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        // Step 1: Frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        // Step 2: MinHeap to process lowest card first
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(freq.keySet());

        // Step 3: Process groups
        while (!minHeap.isEmpty()) {
            int first = minHeap.peek(); // smallest available number

            // Try to form group starting at `first`
            for (int i = 0; i < groupSize; i++) {
                int num = first + i;

                if (!freq.containsKey(num)) return false;

                freq.put(num, freq.get(num) - 1);
                if (freq.get(num) == 0) {
                    if (num != minHeap.peek()) return false; // can't skip ahead
                    minHeap.poll(); // remove it from heap
                }
            }
        }

        return true;
    }
}

    }
}
