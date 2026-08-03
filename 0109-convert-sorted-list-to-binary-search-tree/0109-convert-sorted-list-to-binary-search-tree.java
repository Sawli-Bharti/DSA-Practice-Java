/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private ListNode curr;
    private TreeNode inorder(int left, int right){
        if(left>right) return null;
        int mid=left+(right-left)/2;
        TreeNode leftTree=inorder(left,mid-1);
        TreeNode root=new TreeNode(curr.val);
        curr=curr.next;
        root.left=leftTree;
        root.right=inorder(mid+1,right);
        return root;
    }
    private int size(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        curr=head;
        int n=size(head);
        return inorder(0,n-1);
    }
}