package leetcode_problems.leetcode_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Question1 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        path(root, result, "");
        return result;
    }

    private static void path(TreeNode root, List<String> result, String path) {
        if (root.left == null && root.right == null) result.add(path + root.val);
        if (root.left != null) path(root.left, result, path + root.val + "->");
        if (root.right != null) path(root.right, result, path + root.val + "->");
    }

    public static void main(String[] args) {


        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode three = new TreeNode(3);

        TreeNode root = new TreeNode(1, two, three);

        List<String> result = binaryTreePaths(root);
        for (String str : result) {
            System.out.println(str);
        }

    }

}
