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
    class Pair{
        TreeNode node;
        int d;
        public Pair(TreeNode n, int d){
            node=n;
            this.d=d;
        }
    }
    public Pair dfs(TreeNode root){
        if(root==null){
            return new Pair(null,0);
        }
        Pair left=dfs(root.left);
        Pair right=dfs(root.right);
        if(left.d>right.d) return new Pair(left.node,left.d+1);
        if(right.d>left.d) return new Pair(right.node,right.d+1);
        return new Pair(root,left.d+1);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }
}