/*
Purpose: Analyze the complexities between difference partitioning schemes.
         The first scheme just sorts with merge sort O(nlogn)
         The second scheme partitions with quick sorts partition O(n^2)
         The third scheme partitions recursively O(n^2)
         The fourth scheme finds the median of medians, and uses that
            as a pivot. Theoretically this should be O(n)
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
        //initialize n for size of array
        int n = 1000;
        //Initialize k and ans variables
        int k=n;
        int ans=0;
        //Initialize list of elements to be sorted and searched
        Test_inputs inputs = new Test_inputs();
        int[] array = inputs.fillArray(n);
        
        //Start the timer
        long startTime = System.nanoTime();
        
        //call select_kth_1 to merge sort and return the kth smallest element
//        Select_kth_1 select1 = new Select_kth_1();
//        ans = select1.findKth(array, k);
        
        //call select_kth_2 to iteratively partion with quick sort partition and
        //return the kth smallest element
//        Select_kth_2 select2 = new Select_kth_2();
//        ans = select2.findKth(array, array.length, k);

        //call select_kth_3 to recursively partition with quick sort partition
        //and return the kth smallest element
//        Select_kth_3 select3 = new Select_kth_3();
//        ans = select3.findKth(array, array.length, k);

        //call select_kth_4 to recursively partition with quick sort partition
        //using a better pivot, then return the kth smallest element
        Select_kth_4 select4 = new Select_kth_4();
        ans = select4.Select2(array, array.length, k);
        
        //Find the final time
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        
        //Output time
        System.out.println("Finished computing");
        System.out.println("Execution time in nanoseconds: "+ timeElapsed);

        //Output the kth smallest element
        System.out.println("The kth(k="+k+") smallest element is "+ans);
        
    }
    
    public static void printArray(int[] arr,int size){
        for(int i=0;i<size;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
}
