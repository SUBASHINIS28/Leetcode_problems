/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        if(root==null)
        {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node==null)
            {
                sb.append("null,");
                continue;
            }
            sb.append(node.val).append(",");
            q.offer(node.left);
            q.offer(node.right);
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if(data.equals("null"))
        {
            return null;
        }
        String arr[] = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i=1;
        while(!q.isEmpty())
        {
            TreeNode node=q.poll();
            if(!arr[i].equals("null"))
            {
                TreeNode leftnode = new TreeNode(Integer.parseInt(arr[i]));
                node.left=leftnode;
                q.offer(leftnode);
            }
            i++;
            if(!arr[i].equals("null"))
            {
                TreeNode rightnode = new TreeNode(Integer.parseInt(arr[i]));
                node.right=rightnode;
                q.offer(rightnode);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));