// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

// Example 1:


// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]
// Example 2:

// Input: preorder = [-1], inorder = [-1]
// Output: [-1]
import java.util.HashMap;

public class constructBinaryTreeFromPreorderAnsInorderTraversal {
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
    private int preorderIndex = 0;
    private HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build a map to find index of root in inorder in O(1)
        for(int i=0; i<inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }
        return buildSubTree(preorder, 0, inorder.length-1);
    }

    private TreeNode buildSubTree(int[] preorder, int left, int right){
        if(left>right){
            return null;
        }

        //Get the current root value from preorder
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = inorderIndexMap.get(rootVal);

        root.left = buildSubTree(preorder, left, inorderIndex-1);
        root.right = buildSubTree(preorder, inorderIndex+1, right);

        return root;
    }
}
    }
}
