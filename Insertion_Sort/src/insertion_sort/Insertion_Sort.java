/*
    Insertion sort
        worst case  : O(n^2) comparisons, swaps
        best case   : O(n) comparisons, O(1) swaps

        average     : O(n^2) comparisons, swaps


 */
package insertion_sort;

/**
 *
 * @author bhitt
 */
public class Insertion_Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create array of number elements, not yet sorted
        int[] array = {5,2,4,6,1,3};
        
        //print unsorted array
        System.out.println("Unsorted Array:");
        printArray(array);
        
        //insertion sort algorithm
        insertionSort(array);
        
        //print the new sorted array
        printArray(array);
        
        
    }
    
    public static void printArray(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    public static void insertionSort(int[] a){
        int key;
        int i;
        for(int j=1;j<a.length;j++){    //loop through array starting at second value
            key=a[j];                   //set the key equal to index value
            //insert key into the sorted sequence a[1...j-1]
            i=j-1;
            while(i>=0 && a[i]>key){
                a[i+1] = a[i];
                i=i-1;
            }
            a[i+1]=key;
        }
    }
    
    
    
}
