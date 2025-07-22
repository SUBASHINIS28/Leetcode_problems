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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans  = new ArrayList<>();
        checkpath(root,targetSum,path,ans);
        return ans;
    }
    public void checkpath(TreeNode node, int remaining, List<Integer> path, List<List<Integer>>ans)
    {
        if(node==null)
        {
            return;
        }
        path.add(node.val);
        if(node.left == null && node.right == null && node.val == remaining)
        {
            ans.add(new ArrayList<>(path));
        }
        else
        {
            checkpath(node.left,remaining-node.val,path,ans);
            checkpath(node.right,remaining-node.val,path,ans);
        }
        path.remove(path.size()-1);
            
        
    }
}