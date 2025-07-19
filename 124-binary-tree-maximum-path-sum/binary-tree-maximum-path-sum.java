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
    int max_val = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) 
    {
        maximum(root);
        return max_val;
    }
    public int maximum(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }
        int left = Math.max(maximum(node.left),0);
        int right= Math.max(maximum(node.right),0);
        int curr = left+right+node.val;
        max_val = Math.max(max_val,curr);
        return node.val+Math.max(left,right);
    }
}