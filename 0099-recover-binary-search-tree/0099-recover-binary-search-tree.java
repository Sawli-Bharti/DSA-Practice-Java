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
    TreeNode first=null,sec=null,prev=null;
    public void inorder(TreeNode curr){
        if(curr==null) return;
        inorder(curr.left);
            if(prev!=null && prev.val>curr.val){
                if(first==null){
                     first=prev;
                     sec=curr;
                }
                else sec=curr;
            }
        prev=curr;
        inorder(curr.right);
    }
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        inorder(root);
        int v=first.val;
        first.val=sec.val;
        sec.val=v;
    }
}