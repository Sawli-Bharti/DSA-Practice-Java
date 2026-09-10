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
    int count=0;
    private int size(TreeNode root){
        if(root==null) return 0;
        return 1+size(root.left)+size(root.right);
    }
    private int subtree(TreeNode root){
        if(root==null) return 0;
        int left=subtree(root.left);
        int right=subtree(root.right);
        int sum=root.val+left+right;
        if((sum/size(root))==root.val){
            count++; 
            System.out.println(root.val);}
        return left+right+root.val;

    }
    public int averageOfSubtree(TreeNode root) {
        subtree(root);
        return count;
    }
}