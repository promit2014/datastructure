package org.datastructure.tree.balanced;

import org.datastructure.tree.BinarySearchTree;

public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T> {

  @Override
  public void insertNode(T data) {
    Node<T> newNode = new Node<>();
    newNode.data = data;
    if (this.root == null) {
      this.root = newNode;
    } else {
      this.root = insert(this.root, newNode);
    }
  }

  private Node<T> insert(Node<T> rootNode, Node<T> newNode) {
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

  private Node<T> balanceNode(Node<T> rootNode) {
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

  private int getheight(Node<T> rootNode){
    if (rootNode == null) {
      return 0;
    } else {
      return rootNode.height;
    }
  }

  private int getchildTreeHeight(Node<T> rootNode) {
    if (rootNode == null) {
      return 0;
    } else {
      return rootNode.height + 1;
    }
  }
  
  private Node<T> llRotation(Node<T> rootNode) {
    Node<T> leftNode = rootNode.left;
    Node<T> grandChild = leftNode.right;
    leftNode.right = rootNode;
    rootNode.left = grandChild;

    leftNode.height = calculateHeight(leftNode);
    rootNode.height = calculateHeight(rootNode);

    return leftNode;
  }

  private Node<T> rrRotation(Node<T> rootNode) {
    Node<T> rightNode = rootNode.right;
    Node<T> grandChild = rightNode.left;
    rightNode.left = rootNode;
    rootNode.right = grandChild;

    rightNode.height = calculateHeight(rightNode);
    rootNode.height = calculateHeight(rootNode);

    return rightNode;
  }

  private Node<T> lrRotation(Node<T> rootNode) {
    rootNode.right = llRotation(rootNode.right);
    return rrRotation(rootNode);
  }

  private Node<T> rlRotation(Node<T> rootNode) {
    rootNode.left = rrRotation(rootNode.left);
    return llRotation(rootNode);
  }

  @Override
  public String toString() {
    return "AvlTree [root=" + root + "]";
  }

}