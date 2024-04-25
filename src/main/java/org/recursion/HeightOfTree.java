package org.recursion;

import org.datastructure.tree.BinarySearchTree;

public class HeightOfTree {

    static BinarySearchTree getSingleHeightTree() {
        BinarySearchTree<Long> tree = new BinarySearchTree<>(1l);
        return tree;
    }

    static BinarySearchTree getDoubleHeightTree() {
        BinarySearchTree<Long> tree = new BinarySearchTree<>(1l);
        tree.add(2l);
        return tree;
    }

    static BinarySearchTree getComplexHeightTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(2);
        tree.add(1);
        tree.add(14);
        tree.add(5);
        tree.add(6);
        tree.add(4);
        tree.add(3);
        tree.add(7);
        tree.add(8);
        return tree;
    }

    public static void printHeightOfTree(){
        System.out.println("Single Tree : "+getSingleHeightTree().getTreeHeight());
        System.out.println("Double Tree : "+getDoubleHeightTree().getTreeHeight());
        System.out.println("MultiLevel Tree : "+getComplexHeightTree().getTreeHeight());
    }

}
