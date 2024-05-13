package org.datastructure.tree;

import java.util.Objects;

public class BinarySearchTree<T extends Comparable<T>> {
    protected Node<T> root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(T rootData) {
        if(Objects.isNull(rootData)){
            throw new UnsupportedOperationException("Creating a tree with NULL Root node is not supported");
        }
        root = new Node<>(rootData);
    }

    public class Node<S> {
        public S data;
        public Node<S> left;
        public Node<S> right;
        public int height;

        public Node() {
        this.data = null;
        this.left = null;
        this.right = null;
        this.height = 0;
        }

        public Node(S data){
            this.data = data;
        }

        @Override
        public String toString() {
        return "Node [data=" + data + ", left=" + left + ", right=" + right + ", height=" + height + "]";
        }
    }

    public void insertNode(T data) {
        insertNode(root, data);
    }

    private void insertNode(Node<T> root, T data) {
        if(Objects.isNull(data)){
            throw new UnsupportedOperationException("adding NULL in tree is not supported");
        }else if (root.left == null && (root.data.compareTo(data) > 0)) {
            root.left = new Node<>(data);
        } else if (root.right == null && (root.data.compareTo(data) < 0)) {
            root.right = new Node<>(data);
        } else {
            insertNode(root.data.compareTo(data) >0 ? root.left : root.right, data);
        }
    }

    public int getTreeHeight() {
        return calculateHeight(root);
    }

    protected int calculateHeight(Node<T> rootNode){
        if(rootNode == null){
          return 0;
        }else if(rootNode.left == null && rootNode.right == null){
          return 0;
        }else{
          return Math.max(calculateHeight(rootNode.left), calculateHeight(rootNode.right)) + 1;
        }
      }

    public void deleteNode(T data){

    }

}
