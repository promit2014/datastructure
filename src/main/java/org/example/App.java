package org.example;

import org.recursion.Factorial;
import org.recursion.HeapRunner;
import org.recursion.HeightOfTree;

import java.util.Arrays;
import java.util.Objects;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Long temp = null;
        Factorial.executeFactorial();
        HeightOfTree.printHeightOfTree();
        HeapRunner.heapTester();
    }
}
