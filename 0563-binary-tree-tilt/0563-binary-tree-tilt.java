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
    private int sum=0;
    private int sumSubtree(TreeNode root){
        if(root==null) return 0;
        int left=sumSubtree(root.left);
        int right=sumSubtree(root.right);
        sum+=Math.abs(left-right);
        return root.val+left+right;
    }
    public int findTilt(TreeNode root) {
        if(root==null) return 0;
        int s=sumSubtree(root);
        return sum;
    }
}