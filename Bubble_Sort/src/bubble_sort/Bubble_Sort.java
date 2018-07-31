/*
    Bubble Sort
        worst case  : O(n2)
        best case   : O(n)
        average case: O(n2)
        space       : O(1)
 */
package bubble_sort;

/**
 *
 * @author bhitt
 */
public class Bubble_Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create array of integer elements, not yet sorted
        int[] array = {2,4,5,7,1,2,3,6};
        
        //print unsorted array
        System.out.println("Unsorted Array:");
        printArray(array);
        
        
        //bubble sort algorithm
        bubbleSort(array);
        
        //print the newly sorted array
        System.out.println("After Sort:");
        printArray(array);
    }
    
    public static void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public static void bubbleSort(int[] array){
        //temp value for swaps
        int temp=0;
        //loop bubble start position
        for(int i=0;i<array.length-1;i++){
            //loop comparing to bubble
            for(int j=0;j<array.length - i - 1;j++){
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
