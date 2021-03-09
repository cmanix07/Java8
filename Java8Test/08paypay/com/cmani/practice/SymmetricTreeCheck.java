package com.cmani.practice;

public class SymmetricTreeCheck {

    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int value;

        TreeNode(int value){
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static boolean isSymmetricTree(TreeNode root){

        if(root == null){
            return true;
        }

        return isSymmetricTree(root.left,root.right);
    }

    private static boolean isSymmetricTree(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.value != right.value){
            return false;
        }
        return isSymmetricTree(left.left,right.right) && isSymmetricTree(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

        System.out.println("Tree is symmetric : "+isSymmetricTree(root));
    }

    //To Check the symmetric tree using iteration then we can use the queue for it.
    // take one queue and add root1 and root2 based on the left and right child
    //peek and pop elements from queue.
}
