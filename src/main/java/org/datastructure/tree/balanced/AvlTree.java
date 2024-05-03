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
      this.root = insert(this.root, newNode);
    }
  }

  public Node<T> insert(Node<T> rootNode, Node<T> newNode) {
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

    return balanceNode(rootNode);
  }


  public Node<T> balanceNode(Node<T> rootNode) {
    if (getHeight(rootNode.left) - getHeight(rootNode.right) > 1) {
      if(getHeight(rootNode.left.left) > getHeight(rootNode.left.right)){
        return llRotation(rootNode);
      }else{
        return rlRotation(rootNode);
      }
    }else if (getHeight(rootNode.left) - getHeight(rootNode.right) < -1) {
      if(getHeight(rootNode.right.right) > getHeight(rootNode.right.left)){
        return rrRotation(rootNode);
      }else{
        return lrRotation(rootNode);
      }
    }
    return rootNode;
  }

  public int getHeight(Node<T> rootNode) {
    if (rootNode == null) {
      return 0;
    } else {
      return rootNode.height;
    }
  }

  public int calculateHeight(Node<T> rootNode){
    if(root == null){
      return 0;
    }else if(root.left == null && root.right == null){
      return 0;
    }else{
      return Math.max(calculateHeight(rootNode.left), calculateHeight(rootNode.right));
    }
  }

  public Node<T> llRotation(Node<T> rootNode) {
    Node<T> leftNode = rootNode.left;
    Node<T> grandChild = leftNode.right;
    leftNode.right = rootNode;
    rootNode.left = grandChild;

    leftNode.height = calculateHeight(leftNode);
    rootNode.height = calculateHeight(rootNode);

    return leftNode;
  }

  public Node<T> rrRotation(Node<T> rootNode) {
    Node<T> rightNode = rootNode.right;
    Node<T> grandChild = rightNode.left;
    rightNode.left = rootNode;
    rootNode.right = grandChild;

    rightNode.height = calculateHeight(rightNode);
    rootNode.height = calculateHeight(rootNode);

    return rightNode;
  }

  public Node<T> lrRotation(Node<T> rootNode) {
    rootNode = llRotation(rootNode.left);
    return rrRotation(rootNode);
  }

  public Node<T> rlRotation(Node<T> rootNode) {
    rootNode = rrRotation(rootNode.right);
    return llRotation(rootNode);
  }
}