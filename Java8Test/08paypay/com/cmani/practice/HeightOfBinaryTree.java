package com.cmani.practice;

public class HeightOfBinaryTree {
    TreeNode root;
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int data;
        public  TreeNode(int data){
            this.data = data;
        }
    }

    public int heightOfTree(TreeNode root){
        int leftHeight = 0;
        int rightHeight = 0;
        if (root == null){
            return -1;
        }else {
            leftHeight = heightOfTree(root.left);
            rightHeight = heightOfTree(root.right);
        }
        return Math.max(leftHeight,rightHeight)+1;
    }

    public static void main(String[] args) {
        /**
         * Binary Tree in our example, height = 2
         * 		1		(Root)
         * 	  2	  3		(Level 1)
         *  4    	 5		(Level 2)
         */
        HeightOfBinaryTree binaryTree = new HeightOfBinaryTree();
        binaryTree.root = new TreeNode(1);
        binaryTree.root.left = new TreeNode(2);
        binaryTree.root.right = new TreeNode(3);
        binaryTree.root.left.left = new TreeNode(4);
        binaryTree.root.right.left = new TreeNode(5);

        int heightOfTree = binaryTree.heightOfTree(binaryTree.root);
        System.out.printf("Height of tree is %d", heightOfTree);
    }

}
