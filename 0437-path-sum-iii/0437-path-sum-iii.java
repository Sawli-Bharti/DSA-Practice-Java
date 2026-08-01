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
    private HashMap<Long,Integer> map=new HashMap<>();
    private void solve(TreeNode root, int targetSum,long currSum){
        if(root==null) return;
        currSum+=root.val;
        long rem=currSum-targetSum;
        ans+=map.getOrDefault(rem,0);
        map.put(currSum,map.getOrDefault(currSum,0)+1);
        solve(root.left,targetSum,currSum);
        solve(root.right,targetSum,currSum);
        map.put(currSum,map.get(currSum)-1);
        if(map.get(currSum)==0) map.remove(currSum);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        map.put(0L,1);
        solve(root,targetSum,0L);
        return ans;
    }
}