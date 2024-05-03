package org.example;

import org.recursion.Factorial;
import org.recursion.HeapRunner;
import org.recursion.HeightOfTree;
import org.recursion.AvlTreeRunner;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        Factorial.executeFactorial();
        HeightOfTree.printHeightOfTree();
        HeapRunner.heapTester();
        AvlTreeRunner.avlTester();
    }
}
