package org.recursion;

public class Factorial {

    //Induction
    public long factorial (long inp){
        //base condition
        if(inp == 1) {
            return 1;
        }
        // hypothesis of calling with smaller inputs
        return inp * factorial(inp - 1);
    }

    public static void executeFactorial(){
        // Print Factorial By recursion
        Factorial fact = new Factorial();
        System.out.println(fact.factorial(6));
    }

}
