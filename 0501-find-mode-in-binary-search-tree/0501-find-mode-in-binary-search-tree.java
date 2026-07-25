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
    public void traverse(TreeNode root,HashMap<Integer,Integer> map){
        if(root==null) return;
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        traverse(root.left,map);
        traverse(root.right,map);

    }
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> map=new HashMap<>();
        traverse(root,map);
        int max=Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            max=Math.max(max,e.getValue());
        }
        List<Integer> list=new ArrayList<>();
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(max==e.getValue()) list.add(e.getKey());
        }
        return list.stream()
                    .mapToInt(Integer::intValue)
                     .toArray();
    }
}