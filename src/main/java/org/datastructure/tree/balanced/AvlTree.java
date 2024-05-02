package org.datastructure.tree.balanced;

public class AvlTree<T extends Comparable<T>> {

  Node<T> root;

  private class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;
    int height;

    public Node() {
      this.data = null;
      this.left = null;
      this.right = null;
      this.height = 0;
    }
  }

  public void insertNode(T data) {
    Node<T> newNode = new Node<>();
    newNode.data = data;
    if (this.root == null) {
      this.root = newNode;
    } else {
      insert(this.root, newNode);
    }
  }

  public void insert(Node<T> rootNode, Node<T> newNode) {
    if (newNode.data.compareTo(rootNode.data) <= 0 && rootNode.left == null) {
      rootNode.left = newNode;
      rootNode.height = Math.max(rootNode.left.height, rootNode.height) + 1;
    } else if (newNode.data.compareTo(rootNode.data) >= 0 && rootNode.right == null) {
      rootNode.right = newNode;
      rootNode.height = Math.max(rootNode.right.height, rootNode.height) + 1;
    } else if (newNode.data.compareTo(rootNode.data) <= 0) {
      insert(rootNode.left, newNode);
    } else {
      insert(rootNode.right, newNode);
    }

    if (Math.abs(getHeight(rootNode.left) - getHeight(rootNode.right)) > 1) {
      balanceNode(rootNode);
    }
  }

  public int getHeight(Node<T> rootNode) {
    if (rootNode == null) {
      return 0;
    } else {
      return rootNode.height;
    }
  }

  public Node<T> llRotation(Node<T> rootNode) {
    Node<T> leftNode = rootNode.left;
    Node<T> grandChild = leftNode.right;
    leftNode.right = rootNode;
    rootNode.left = grandChild;
    return leftNode;
  }

  public Node<T> rrRotation(Node<T> rootNode) {
    Node<T> rightNode = rootNode.right;
    Node<T> grandChild = rightNode.left;
    rightNode.left = rootNode;
    rootNode.right = grandChild;
    return rightNode;
  }

  public Node<T> lrRotation(Node<T> rootNode) {
    return null;
  }

  public Node<T> rlRotation(Node<T> rootNode) {
    return null;
  }

  public void balanceNode(Node<T> rootNode) {

  }
}