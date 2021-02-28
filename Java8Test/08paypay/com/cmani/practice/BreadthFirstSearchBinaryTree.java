package com.cmani.practice;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchBinaryTree {

    TreeNode root;
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int data;
        public  TreeNode(int data){
            this.data = data;
        }
    }

    public void displayNodeByTreeLevel(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.remove();
                System.out.println(" "+node.data);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        /**
         * Binary Tree in our example, height = 2
         * 		1		(Root)
         * 	  2	  3		(Level 1)
         *  4    	 5		(Level 2)
         */
        BreadthFirstSearchBinaryTree binaryTree = new BreadthFirstSearchBinaryTree();
        binaryTree.root = new BreadthFirstSearchBinaryTree.TreeNode(1);
        binaryTree.root.left = new BreadthFirstSearchBinaryTree.TreeNode(2);
        binaryTree.root.right = new BreadthFirstSearchBinaryTree.TreeNode(3);
        binaryTree.root.left.left = new BreadthFirstSearchBinaryTree.TreeNode(4);
        binaryTree.root.right.left = new BreadthFirstSearchBinaryTree.TreeNode(5);

        binaryTree.displayNodeByTreeLevel(binaryTree.root);

    }
}
