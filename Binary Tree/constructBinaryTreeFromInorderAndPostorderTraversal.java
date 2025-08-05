// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

// Example 1:


// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]
// Example 2:

// Input: inorder = [-1], postorder = [-1]
// Output: [-1]

import java.util.HashMap;

public class constructBinaryTreeFromInorderAndPostorderTraversal {
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
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();
    private int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length-1;
        //Build inorder index map
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }

        return buildSubTree(postorder, 0, inorder.length-1);
    }

    private TreeNode buildSubTree(int[] postorder, int left, int right){
        if(left>right) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = inorderMap.get(rootVal);

        root.right = buildSubTree(postorder, inorderIndex + 1, right);
        root.left = buildSubTree(postorder, left, inorderIndex - 1);

        return root;

    }
}
    }
}
