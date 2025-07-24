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
    int pre=0;
    Map<Integer,Integer> mp=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return build(preorder,pre,inorder.length-1);
    }
    public TreeNode build(int[] preorder,int st,int end){
        if(st>end){
            return null;
        }
        int rootval=preorder[pre++];
        TreeNode root=new TreeNode(rootval);
        int ind=mp.get(rootval);
        root.left=build(preorder,st,ind-1);
        root.right=build(preorder,ind+1,end);
        return root;
    }

}