package com.cmani.practice;

class BinaryTree {

    public TreeNode root;

    public static class TreeNode {

        public TreeNode left;
        public TreeNode right;
        public Object data;

        public TreeNode(Object data) {
            this.data = data;
            left = right = null;
        }
    }
}

public class PrintLevelsOfTree {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        /**
         * Binary Tree in our example, height = 2
         * 		1		(Root)
         * 	  2	  3		(Level 1)
         *      4       5		(Level 2)
         */
        binaryTree.root = new BinaryTree.TreeNode(1);
        binaryTree.root.left = new BinaryTree.TreeNode(2);
        binaryTree.root.right = new BinaryTree.TreeNode(3);
        binaryTree.root.left.left = new BinaryTree.TreeNode(4);
        binaryTree.root.right.left = new BinaryTree.TreeNode(5);

        printLevelsRecursively(binaryTree.root);
    }

    private static void printLevelsRecursively(BinaryTree.TreeNode root) {
        int height = heightOfTree(root);

        for (int i = 1; i <= height; i++) {
            System.out.print("Level " + i + " : ");
            printSingleLevelRecursively(root, i);
            System.out.println();

        }
    }

    private static int heightOfTree(BinaryTree.TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private static void printSingleLevelRecursively(BinaryTree.TreeNode root, int level) {
        if (root == null)
            return;

        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printSingleLevelRecursively(root.left, level - 1);
            printSingleLevelRecursively(root.right, level - 1);
        }
    }
}