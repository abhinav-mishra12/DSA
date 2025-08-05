// Given the root of a binary tree, return the maximum width of the given tree.

// The maximum width of a tree is the maximum width among all levels.

// The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

// It is guaranteed that the answer will in the range of a 32-bit signed integer.

 

// Example 1:


// Input: root = [1,3,2,5,3,null,9]
// Output: 4
// Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
// Example 2:


// Input: root = [1,3,2,5,null,null,9,6,null,7]
// Output: 7
// Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
// Example 3:


// Input: root = [1,3,2,5]
// Output: 2
// Explanation: The maximum width exists in the second level with length 2 (3,2).
import java.util.LinkedList;
import java.util.Queue;

public class maximumWidthOfABinaryTree {
    public static void main(String[] args) {

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        // Queue for BFS traversal: stores pairs of TreeNode and its index
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0)); // Start with root at index 0

        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().getValue(); // For normalization
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> current = queue.poll();
                TreeNode node = current.getKey();
                int index = current.getValue() - minIndex; // Normalize to avoid overflow

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (node.left != null)
                    queue.offer(new Pair<>(node.left, 2 * index));
                if (node.right != null)
                    queue.offer(new Pair<>(node.right, 2 * index + 1));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }

    // Custom Pair class since Java doesn't have a built-in generic Pair
    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }
}

    }
}
