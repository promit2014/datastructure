package org.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <T>
 *            Heap is a Tree which is sorted by nature.
 *            If it is MAX heap then it means the root is the max value in the
 *            tree.
 *            MIN tree is just opposite to MAX heap.
 *
 *            Heap is tree which is represented by an Array instead of a node
 *            class.
 *            It is a balanced tree.
 */
public class Heap<T extends Comparable<T>> {

  List<T> list;

  public Heap() {
    list = new ArrayList<>();
  }

  public Heap(List<T> userDefList) {
    list = userDefList;
  }

  /**
   * This functions insert new node in the Array representation of the Heap
   * 
   * @param data is the new Data Value that is supposed to be added in the Heap
   */
  public void insert(T data) {
    list.add(data);
    upHeap(list.size() - 1);
  }

  /**
   * This function recursively check the value of the parent with the cuurent
   * node,
   * replaces the values if it is less
   * 
   * @param index
   */
  private void upHeap(int index) {
    if (index == 0) {
      return;
    } else {
      int parentIndex = getParentIndex(index);
      if (list.get(index).compareTo(list.get(parentIndex)) < 0) {
        swapByIndex(list, index, parentIndex);
        upHeap(parentIndex);
      }
    }
  }

  public T remove() {
    if (list.isEmpty()) {
      throw new UnsupportedOperationException("HEAP is empty");
    }

    T data = list.get(0);

    list.set(0, list.get(list.size() - 1));
    list.remove(list.size() - 1);
    downHeap(0);

    return data;
  }

  private void downHeap(int index) {

    int leftChild = getLeftChildIndex(index);
    int rightChild = getRightChildIndex(index);
    int smallestIndexNode;

    if (leftChild > list.size() - 1 && rightChild > list.size() - 1) {
      return;
    } else if (leftChild <= list.size() - 1 && rightChild <= list.size() - 1) {
      smallestIndexNode = list.get(leftChild).compareTo(list.get(rightChild)) < 0 ? leftChild : rightChild;
    } else if (leftChild > list.size() - 1) {
      smallestIndexNode = rightChild;
    } else {
      smallestIndexNode = leftChild;
    }
    if (list.get(index).compareTo(list.get(smallestIndexNode)) > 0) {
      swapByIndex(list, index, smallestIndexNode);
      downHeap(smallestIndexNode);
    }
  }

  /**
   * This Functions returns the parent of the current node Index passed
   * 
   * @param currentIndex
   * @return The index of the parent in the array representation of the Heap
   */
  private int getParentIndex(int currentIndex) {
    if (currentIndex == 0) {
      return 0;
    } else {
      return (currentIndex - 1) / 2;
    }
  }

  /**
   * This Function return the left child of the current node passed
   * 
   * @param currectIndex
   * @return the index of the left child of the node passed
   */
  private int getLeftChildIndex(int currectIndex) {
    return (currectIndex * 2) + 1;
  }

  /**
   * This Function returns the right child of the current node passed
   * 
   * @param currentIndex
   * @return the index of the right child of the node passed
   */
  private int getRightChildIndex(int currentIndex) {
    return (currentIndex * 2) + 2;
  }

  /**
   * This functions return swaps the valyes of the two indexes passes with the
   * list
   * 
   * @param list   representation of the tree
   * @param first  index whose value needs to be replaced
   * @param second index whose value needs to be replaced
   */
  private void swapByIndex(List<T> list, int first, int second) {
    T temp = list.get(first);
    list.set(first, list.get(second));
    list.set(second, temp);
  }

  /**
   * This is a method that is used for converting a binary tree in array
   * representation to a Heap/PriorityQueue
   *
   */
  public void heapify() {
    if (list.size() <= 0) {
      throw new UnsupportedOperationException("Tree size should be more than 1 element for heapifying");
    }
    heapify(list.size() - 1);
  }

  /**
   * This is a recursive method that swaps the value of the minimum number with
   * the value of the child nodes
   * except the leaf nodes
   * 
   * @param index
   */
  private void heapify(int index) {
    int leftChild = getLeftChildIndex(index);
    int rightChild = getRightChildIndex(index);
    if (leftChild <= list.size() - 1 || rightChild <= list.size() - 1) {
      downHeap(index);
    }
    if (index > 0) {
      heapify(index - 1);
    }
  }

  @Override
  public String toString() {
    return "Heap : " + list;
  }
}
