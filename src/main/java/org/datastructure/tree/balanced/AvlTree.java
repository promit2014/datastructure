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
      rootNode.height = rootNode.left.height < rootNode.height ? rootNode.height : 1;
    } else if (newNode.data.compareTo(rootNode.data) >= 0 && rootNode.right == null) {
      rootNode.right = newNode;
      rootNode.height = rootNode.right.height < rootNode.height ? rootNode.height : 1;
    } else if (newNode.data.compareTo(rootNode.data) <= 0) {
      rootNode.left = insert(rootNode.left, newNode);
      rootNode.height = Math.max(getheight(rootNode.left), getheight(rootNode)) + 1;
    } else {
      rootNode.right = insert(rootNode.right, newNode);
      rootNode.height = Math.max(getheight(rootNode.right), getheight(rootNode)) + 1;
    }

    return balanceNode(rootNode);
  }


  public Node<T> balanceNode(Node<T> rootNode) {
    if (getchildTreeHeight(rootNode.left) - getchildTreeHeight(rootNode.right) > 1) {
      if(getchildTreeHeight(rootNode.left.left) > getchildTreeHeight(rootNode.left.right)){
        return llRotation(rootNode);
      }else{
        return rlRotation(rootNode);
      }
    }else if (getchildTreeHeight(rootNode.left) - getchildTreeHeight(rootNode.right) < -1) {
      if(getchildTreeHeight(rootNode.right.right) > getchildTreeHeight(rootNode.right.left)){
        return rrRotation(rootNode);
      }else{
        return lrRotation(rootNode);
      }
    }
    return rootNode;
  }

  public int getheight(Node<T> rootNode){
    if (rootNode == null) {
      return 0;
    } else {
      return rootNode.height;
    }
  }

  public int getchildTreeHeight(Node<T> rootNode) {
    if (rootNode == null) {
      return 0;
    } else {
      return rootNode.height + 1;
    }
  }

  public int calculateHeight(Node<T> rootNode){
    if(rootNode == null){
      return 0;
    }else if(rootNode.left == null && rootNode.right == null){
      return 0;
    }else{
      return Math.max(calculateHeight(rootNode.left), calculateHeight(rootNode.right)) + 1;
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
    rootNode.right = llRotation(rootNode.right);
    return rrRotation(rootNode);
  }

  public Node<T> rlRotation(Node<T> rootNode) {
    rootNode.left = rrRotation(rootNode.left);
    return llRotation(rootNode);
  }
}