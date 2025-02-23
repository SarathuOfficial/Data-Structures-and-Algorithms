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
    private int preIdx = 0;
    private int postIdx = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode curr = new TreeNode(preorder[preIdx]);
        preIdx++;

        if (curr.val != postorder[postIdx]) {
            curr.left = constructFromPrePost(preorder, postorder);
        }
        if (curr.val != postorder[postIdx]) {
            curr.right = constructFromPrePost(preorder, postorder);
        }

        postIdx++;
        return curr;
    }
}