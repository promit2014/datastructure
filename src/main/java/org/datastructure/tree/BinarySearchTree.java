package org.datastructure.tree;

import java.util.Objects;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(T rootData) {
        if(Objects.isNull(rootData)){
            throw new UnsupportedOperationException("Creating a tree with NULL Root node is not supported");
        }
        root = new Node<T>(rootData);
    }

    public static class Node<T> {
        private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        add(root, data);
    }

    private void add(Node<T> root, T data) {
        if(Objects.isNull(data)){
            throw new UnsupportedOperationException("adding NULL in tree is not supported");
        }else if (root.leftChild == null && (root.data.compareTo(data) > 0)) {
            root.leftChild = new Node<T>(data);;
        } else if (root.rightChild == null && (root.data.compareTo(data) < 0)) {
            root.rightChild = new Node<T>(data);
        } else {
            add(root.data.compareTo(data) >0 ? root.leftChild : root.rightChild, data);
        }
    }

    public Long getTreeHeight() {
        return getTreeHeight(root);
    }

    public Long getTreeHeight(BinarySearchTree.Node root) {
        if (root == null) {
            return 0l;
        }
        Long leftHeight = getTreeHeight(root.leftChild);
        Long rightHeight = getTreeHeight(root.rightChild);

        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    public void deleteNode(T data){

    }

}
