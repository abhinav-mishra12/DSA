// Given a binary tree, determine if it is height-balanced.

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: true
// Example 2:


// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false
// Example 3:

// Input: root = []
// Output: true
public class balancedBinaryTree {
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
    public boolean isBalanced(TreeNode root) {
        //To check if it is balance or not we have to check (!(lh-rh)>1)
        return checkHeight(root)!=-1;
    }

    private int checkHeight(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftHeight = checkHeight(root.left);
        if(leftHeight==-1) return -1;

        int rightHeight = checkHeight(root.right);
        if(rightHeight==-1) return -1;

        if(Math.abs(leftHeight-rightHeight)>1) return -1;

        return Math.max(leftHeight, rightHeight)+1;
    }

}
    }
}
