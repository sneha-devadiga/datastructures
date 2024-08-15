package Tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BinarySearchTreeToGreaterSumTree {
    int prefix = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        bstToGst(root.right);
        root.val += prefix;
        prefix = root.val;
        bstToGst(root.left);
        return root;
    }

    public void print(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>(Arrays.asList(root));
        while (!q.isEmpty()) {
            for (int sz = q.size(); sz > 0; --sz) {
                TreeNode temp = q.poll();
                System.out.print(temp.val+"\t");
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
    }
}
