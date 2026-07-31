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
    private void solve(List<List<Integer>> ans,List<Integer> list,TreeNode root, int targetSum){
        if(root==null) return;
        if(root.left==null && root.right==null && targetSum==root.val){
            list.add(root.val);
            ans.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        solve(ans,list,root.left,targetSum-root.val);
        solve(ans,list,root.right,targetSum-root.val);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        solve(ans,new ArrayList<>(),root,targetSum);
        return ans;
    }
}