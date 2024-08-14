package BFS;

import BFS.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int h = height(root) - 1;
        while (!queue.isEmpty() && h > 0) {
            h--;
            for (int sz = queue.size(); sz > 0; sz--) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return queue.stream().mapToInt(node -> node.val).sum();
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.right), height(node.left));
    }

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        TreeNode _5 = new TreeNode(5);
        TreeNode _6 = new TreeNode(6);
        TreeNode _7 = new TreeNode(7);
        TreeNode _8 = new TreeNode(8);

        _4.left = _7;
        _6.right = _8;
        _2.left = _4;
        _2.right = _5;
        _3.right = _6;
        _1.left = _2;
        _1.right = _3;

        DeepestLeavesSum deepestLeavesSum = new DeepestLeavesSum();
        System.out.println(deepestLeavesSum.deepestLeavesSum(_1));




    }
}
