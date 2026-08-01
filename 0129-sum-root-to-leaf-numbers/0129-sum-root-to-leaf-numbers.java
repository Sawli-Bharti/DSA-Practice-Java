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
    private int dfs(TreeNode root,int n){
        if(root==null) return 0;
        
        n+=root.val;
        
        if(root.left==null && root.right==null){
            return n;
        }
        n*=10;
        return dfs(root.left,n)+dfs(root.right,n);
    }
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        return dfs(root,0);
    }
}