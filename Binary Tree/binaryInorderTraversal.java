import java.util.ArrayList;
import java.util.List;

public class binaryInorderTraversal {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helperInorderTraversal(root, ans);
        return ans;
    }

    private void helperInorderTraversal(TreeNode root, List<Integer> ans){
        if(root==null){
            return;
        }
        helperInorderTraversal(root.left, ans);
        ans.add(root.val);
        helperInorderTraversal(root.right, ans);
    }
}
    }
}
