/*

 */
package binary_tree;

/**
 *
 * @author bhitt
 */
public class Node {
    //Properties
    Node left, right;
    int data;
    
    //Default Constructor
    public Node(int data){
        this.data = data;
    }
    
    //Inserting a value correctly into the tree
    public void insert(int value){
        if(value <= data){
            if(left==null){
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if(right ==null){
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }
    
    //Searching for a value in the tree
    public boolean contains(int value){
        if(value == data){
            return true;
        } else if (value < data){
            if(left == null){
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null){
                return false;
            } else {
                return right.contains(value);
            }
        }
    }
    
    //Print In-Order Traversal
    //Print left child, then root, then right child
    public void printInOrder(){
      if(left != null){
          left.printInOrder();
      }
      System.out.println(data);
      if(right != null){
          right.printInOrder();
      }
    }
    
    //Print Pre-Order
    //print root, then left child, then right child
    
    
    //Print Post-Order traversal
    //print left child, then right child, then root
}
