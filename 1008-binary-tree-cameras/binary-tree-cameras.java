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
    int cam = 0;
    public int minCameraCover(TreeNode root) 
    {
       if(camcount(root)==0) 
       {
        cam++;
       }
       return cam;
    }
    public int camcount(TreeNode node)
    {
        if(node==null)
        {
            return -1;
        }
        int left = camcount(node.left);
        int right = camcount(node.right);
        if(left==0 || right==0)
        {
            cam++;
            return 1;
        }
        if(left==1 || right==1)
        {
            return -1;
        }
        return 0;
    }
}