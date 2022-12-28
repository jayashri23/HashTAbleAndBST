package com.hashtableandbst;

public class BinarySearch <T extends Comparable<T>> {
    //Nested class
    static class MyBinaryNode<T> {

        //Define variables for Binary Search Tree
        T data;
        MyBinaryNode left;
        MyBinaryNode right;

        //Declaring parameterized constructor
        MyBinaryNode(T value) {
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }

    MyBinaryNode root = null;

    //Adding to Binary Search Tree. (by means of LinkedList)
    public void addToBST(T data) {
        this.root = this.insertRec(this.root, data);
    }

    //Utility function to insert a new node with given data in BST.
    public MyBinaryNode insertRec(MyBinaryNode node, T data) {
        if (node == null) {
            this.root = new MyBinaryNode(data);
            return this.root;
        }

        int comparator = data.compareTo((T) node.data);
        /* Otherwise, recursively adding down the tree */
        if (comparator <= 0) {
            node.left = this.insertRec(node.left, data);
        } else {
            node.right = this.insertRec(node.right, data);
        }
        return node;
    }

    //Printing the Binary Search Tree.
    public void traversal() {
        inorderUtil(this.root);
    }

    // Utility function for inorder traversal of tree.
    public void inorderUtil(MyBinaryNode node) {
        if (node == null) {
            return;
        }

        inorderUtil(node.left);
        System.out.print(node.data + " ");
        inorderUtil(node.right);
    }

    public static void main(String[] args) {
        BinarySearch tree = new BinarySearch();

        //Adding values to BST
        tree.addToBST(56);
        tree.addToBST(30);
        tree.addToBST(70);

        //Printing all the values of BST
        tree.traversal();

    }
}