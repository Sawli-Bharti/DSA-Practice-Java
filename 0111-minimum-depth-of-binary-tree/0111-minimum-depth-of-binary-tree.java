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
    int d=Integer.MAX_VALUE;
    public void traverse(TreeNode root , int count){
        if(root==null){
            return;
        }
        
        count++;
        if(root.left==null && root.right==null){
            d=Math.min(d,count);
            return;
        }
        traverse(root.left,count);
        count--;
        count++;
        traverse(root.right,count);

    }
    public int minDepth(TreeNode root) {
        if(root==null ) return 0;
        traverse(root,0);
        return d;
    }
}