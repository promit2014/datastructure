package org.recursion;
import org.datastructure.tree.balanced.AvlTree;

public class AvlTreeRunner {
  public static void avlTester() {
    AvlTree<Integer> avl = new AvlTree<>();
    avl.insertNode(8);
    avl.insertNode(1);
    avl.insertNode(6);
    avl.insertNode(3);
    avl.insertNode(2);
    avl.insertNode(4);
    System.out.println("============AVL TREE=============");
  }
}
