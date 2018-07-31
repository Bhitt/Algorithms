/*
    Quick Sort  (utilizing random pivot)
        worst case  : O(n2)
        best case   : O(n log n)
        average case: O(n log n)
        space       : O(n)
 */
package quick_sort;

import java.util.Random;

/**
 *
 * @author bhitt
 */
public class Quick_Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create array of integer elements, not yet sorted
        int[] array = {2,4,5,7,1,2,3,6};
        
        //print unsorted array
        System.out.println("Unsorted Array:");
        printArray(array);
        
        
        //quick sort algorithm
        quickSort(array);
        
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
    
    public static void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);
    }
    
    private static void quickSort(int[] array, int low, int high){
        if(low < high+1){
            int p = partition(array, low, high);
            quickSort(array, low, p-1);
            quickSort(array, p+1, high);
        }
    }
    
    private static void swap(int[] array, int index1, int index2){
        int temp =  array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
    //returns random pivot index between low and high inclusive
    private static int getPivot(int low, int high){
        Random rand =  new Random();
        return rand.nextInt((high - low) +1) + low;
    }
    
    
    //moves all n <  pivot to left of pivot and all n > pivot
    //to right of pivot, then returns pivot index
    private static int partition(int[] array, int low, int high){
        //
        swap(array, low, getPivot(low, high));
        int border = low +1;
        for(int i=border; i<= high; i++){
            if(array[i] < array[low]){
                swap(array, i , border++);
            }
        }
        swap(array, low, border-1);
        return border-1;
    }
}
