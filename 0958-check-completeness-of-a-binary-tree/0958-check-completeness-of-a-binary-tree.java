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
    private boolean flag=true;
    private int heightSubtree(TreeNode root){
        if(root==null) return 0;
        int left=heightSubtree(root.left);
        int right=heightSubtree(root.right);
        return 1+Math.max(left,right);
    }
    public void bfs(TreeNode root, int d){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int h=d;
        while(!q.isEmpty()){
            int n=q.size();
            if(h!=0 && n!=Math.pow(2,d-h)){
                flag=false;
                return;
            }
            boolean isNullBtw=false;
            while(n>0){
                TreeNode node=q.poll();
                if(node==null){
                    isNullBtw=true;
                    while(!q.isEmpty() && q.peek()==null) q.poll();
                    break;
                }
                if(node.left!=null) q.offer(node.left);
                else if(h==2)q.offer(null);
                if(node.right!=null) q.offer(node.right);
                else if(h==2) q.offer(null);
                n--;

            }
            if(isNullBtw && !q.isEmpty()){
                flag=false;
                return;
            }
            h--;
        }
    }
    public boolean isCompleteTree(TreeNode root) {
        if(root==null) return true;
        int d=heightSubtree(root);
        bfs(root,d);
        return flag;
    }
}