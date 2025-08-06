// Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

 

// Example 1:


// Input: root = [5,3,6,2,4,null,7], k = 9
// Output: true
// Example 2:


// Input: root = [5,3,6,2,4,null,7], k = 28
// Output: false
import java.util.ArrayList;
import java.util.List;

public class twoSum4InputIsABST {
    public static void main(String[] args) {
        /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        inorder(root);  // fill list with sorted values

        int n = 0;
        int m = list.size() - 1;

        while (n < m) {
            int sum = list.get(n) + list.get(m);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                n++;
            } else {
                m--;
            }
        }

        return false;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);   // in-order adds values in sorted order for BST
        inorder(root.right);
    }
}

    }
}
