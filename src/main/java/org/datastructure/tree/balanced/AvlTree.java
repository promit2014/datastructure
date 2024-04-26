package org.datastructure.tree.balanced;

public class AvlTree<T extends Comparable<T>> {
    private AvlNode<T> root;

    private static class AvlNode<T> {
        T data;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;

        AvlNode(T data) {
            this.data = data;
            this.height = 1;
        }
    }
}