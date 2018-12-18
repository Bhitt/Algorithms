/*
    Data Structure: Stack
    Last In First Out (LIFO)
    
 */
package data_structure_stack;

import java.util.Random;

/**
 *
 * @author bhitt
 */
public class Data_Structure_Stack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //random number variable
        Random rand = new Random();
        int n = 0;
        //STACK EXAMPLE
        //Create the stack
        Stack stack = new Stack();
        //check to see if empty
        System.out.println("Is the stack empty: "+stack.isEmpty());
        //push five random numbers to the stack
        for(int i=0;i<5;i++){
            n = rand.nextInt(50);
            System.out.println("Pushing "+n+" to the stack.");
            stack.push(n);
        }
        //pop two numbers off the stack
        System.out.println(stack.pop()+" was popped off the stack");
        System.out.println(stack.pop()+" was popped off the stack");
        
        //check to see if empty
        System.out.println("Is the stack empty: "+stack.isEmpty());
        
    }
    
}
