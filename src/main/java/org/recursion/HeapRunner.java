package org.recursion;

import org.datastructure.tree.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapRunner {
  public static void heapTester() {
    Heap<Integer> heap = new Heap<>();
    heap.insert(8);
    heap.insert(1);
    heap.insert(6);
    heap.insert(3);
    heap.insert(2);
    heap.insert(4);
    System.out.println(heap.toString());
    System.out.println("=========================");

    List<Integer> unorderedList = new ArrayList<>(Arrays.asList(8, 1, 6, 3, 2, 4));
    Heap<Integer> heap1 = new Heap<>(unorderedList);
    heap1.heapify();
    System.out.println(Arrays.asList(8, 1, 6, 3, 2, 4) + "  =>  " + heap1.toString());

  }
}
