import java.util.ArrayList;
import java.util.List;

public class binaryTreePostorderTraversal {
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helperPostorderTraversal(root, ans);
        return ans;
    }

    private void helperPostorderTraversal(TreeNode root, List<Integer> ans){
        if(root==null){
            return;
        }
        helperPostorderTraversal(root.left, ans);
        helperPostorderTraversal(root.right, ans);
        ans.add(root.val);
    }
}
    }
}
