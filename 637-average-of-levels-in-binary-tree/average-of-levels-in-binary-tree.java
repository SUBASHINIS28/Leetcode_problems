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
        public static List<Double> averageOfLevels(TreeNode root)
    {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> current = new LinkedList<>();
        current.offer(root);
        while (!current.isEmpty()) 
        {
            Queue<TreeNode> next = new LinkedList<>();
            long sum = 0;
            int count = 0;
            while (!current.isEmpty())
            {
                TreeNode node = current.poll();
                sum += node.val;
                count++;
                if (node.left != null) next.offer(node.left);
                if (node.right != null) next.offer(node.right);
            }

            result.add((double) sum / count);
            current = next;
        }

        return result;
    }
}