package org.recursion;

import org.datastructure.tree.BinarySearchTree;

public class HeightOfTree {

    static BinarySearchTree getSingleHeightTree() {
        BinarySearchTree<Long> tree = new BinarySearchTree<>(1l);
        return tree;
    }

    static BinarySearchTree getDoubleHeightTree() {
        BinarySearchTree<Long> tree = new BinarySearchTree<>(1l);
        tree.insertNode(2l);
        return tree;
    }

    static BinarySearchTree getComplexHeightTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(2);
        tree.insertNode(1);
        tree.insertNode(14);
        tree.insertNode(5);
        tree.insertNode(6);
        tree.insertNode(4);
        tree.insertNode(3);
        tree.insertNode(7);
        tree.insertNode(8);
        return tree;
    }

    public static void printHeightOfTree(){
        System.out.println("Single Tree : "+getSingleHeightTree().getTreeHeight());
        System.out.println("Double Tree : "+getDoubleHeightTree().getTreeHeight());
        System.out.println("MultiLevel Tree : "+getComplexHeightTree().getTreeHeight());
    }

}
