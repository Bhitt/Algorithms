/*
    Stack object implemented with an array of max elements n
 */
package data_structure_stack;

import java.util.Objects;

/**
 *
 * @author bhitt
 */
public class Stack {
    //Properties
    private Integer top;
    private final Integer[] stack;
    private final Integer n;
    
    //Constructor
    public Stack(){
        top=0;
        n=20;
        stack = new Integer[n];
    }
    //isEmpty method: check to see if the stack is empty
    public boolean isEmpty(){
        return top == 0;
    }
    
    //push a number to the stack
    public void push(Integer x){
        if(Objects.equals(top, n)){
            //overflow case
            System.out.println("Error: Cannot push element, size n exceeded.");
        }else{
            top+=1;
            stack[top-1] = x;
        }
    }
    
    //pop a number off the stack
    public Integer pop(){
        if(this.isEmpty()){
           //this is an underflow error
           return null;
        }else{
            top-=1;
            return stack[top];
        }
    }
}
