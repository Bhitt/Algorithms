/*
    Merge Sort
        worst case  : O(n log(n))
        best case   : O(n log(n))
        average case: O(n log(n))
        space       : O(n)
 */
package merge_sort;

/**
 *
 * @author bhitt
 */
public class Merge_Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //create array of integer elements, not yet sorted
        int[] array = {2,4,5,7,1,2,3,6};
        
        //print unsorted array
        System.out.println("Unsorted Array:");
        printArray(array);
        
        
        //merge sort algorithm
        mergeSort(array);
        
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
    
    //Helper method
    public static void mergeSort(int[] array){
        /*begin merge sort using: the array to be sorted,
                                  a temporary array to help merge
                                  a starting index (0 in this case)
                                  an ending index (the last element in this case)
        */
        mergeSort(array,new int[array.length],0,array.length -1);
    }
    
    public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd){
        //Check for out of bounds
        if(leftStart >= rightEnd){
            return;
        }
        //find the center
        int middle = (leftStart + rightEnd) /2;
        //call mergeSort on left half
        mergeSort(array, temp, leftStart, middle);
        //call mergeSort on the right half
        mergeSort(array, temp, middle+1, rightEnd);
        //merge the two halves
        mergeHalves(array, temp, leftStart, rightEnd);
    }
    
    public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd){
        //find positions
        int leftEnd = (rightEnd + leftStart)/2;
        int rightStart = leftEnd +1;
        //find size of array
        int size = rightEnd - leftStart +1;
        
        //find indexes
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        
        //walk through and compare elements to be merged
        while(left <= leftEnd && right <= rightEnd){
            if(array[left] <= array[right]){
                temp[index] = array[left];
                left++;
            }else{
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        
        //copy remainder of elements over using built-in java function
        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }
}
