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
    public boolean isBalanced(TreeNode root) 
    {
        return checkheight(root) !=-1;      
    }
    public int checkheight(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }
        int left=checkheight(node.left);
        int right=checkheight(node.right);
        if(left==-1||right==-1)
        {
            return -1;
        }
        if(Math.abs(left-right)>1)
        {
            return -1;
        }
        return 1+Math.max(left,right);
    }
}