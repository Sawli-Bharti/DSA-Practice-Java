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
    private int  ans=0;
    private void traverse(TreeNode root, int t){
        if(root==null) return;
        solve(root,t,0);
        traverse(root.left,t);
        traverse(root.right,t);
    }
    private void solve(TreeNode root, int targetSum,long sum){
        if(root==null) return;
        sum+=root.val;
        if(sum==targetSum){
            ans++;
        }
        solve(root.left,targetSum,sum);
        solve(root.right,targetSum,sum);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        traverse(root,targetSum);
        return ans;
    }
}