/*
    
 */
package kth_smallest;

/**
 *
 * @author bhitt
 */
public class Kth_Smallest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initialize k and ans variables
        int k=1;
        int ans=0;
        //Initialize list of elements to be sorted and searched
        
        //size n = 10
        int[] array = {3,5,4,1,6,7,2,8,9,10};
        
        //call algorithm 1 to merge sort and find return the kth smallest element
//        Algorithm1 alg1 = new Algorithm1();
//        ans = alg1.findKth(array, k);
        
        //call
        Algorithm2 alg2 = new Algorithm2();
        ans = alg2.findKth(array, array.length-1, k);
        
        //Output the kth smallest element
        System.out.println("The kth(k="+k+") smallest element is "+ans);
        
    }
    
}
