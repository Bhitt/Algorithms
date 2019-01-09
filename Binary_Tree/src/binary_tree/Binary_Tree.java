/*

 */
package binary_tree;

import java.util.Random;

/**
 *
 * @author bhitt
 */
public class Binary_Tree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Rand seed stuff
        Random r = new Random();
        
        // Create a root node and insert more nodes into the tree
        System.out.println("Creating a tree of 7 random numbers [1-20]");
        Node root = new Node(r.nextInt((20 - 1) + 1) + 1);
        root.insert(r.nextInt((20 - 1) + 1) + 1);
        root.insert(r.nextInt((20 - 1) + 1) + 1);
        root.insert(r.nextInt((20 - 1) + 1) + 1);
        root.insert(r.nextInt((20 - 1) + 1) + 1);
        root.insert(r.nextInt((20 - 1) + 1) + 1);
        root.insert(r.nextInt((20 - 1) + 1) + 1);
        
        //find if the tree contains the values 3 and 5
        System.out.println("Does the tree contain 3: "+root.contains(3));
        System.out.println("Does the tree contain 5: "+root.contains(5));
        
        //print out the tree
        System.out.println("Printing the tree in order...");
        root.printInOrder();
        
        
        
    }
    
}
