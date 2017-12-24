/*
Book: Introduction to Algorithms (3rd edition)
    exercises: 2.1-2  through  2.1-4 (unfinished)
 */
package exercises_insertion_sort;

/**
 *
 * @author bhitt
 */
public class Exercises_Insertion_Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // run exercises
        ex2();
        
    }
    
    public static void ex2(){
        /* Rewrite the INSERTION-SORT procedure to sort into non-increasing instead of non-decreasing order */
        
        //create array
        int[] array =  {31,41,59,26,41,58};
        
        //sort in reverse order
        int key,i;
        for(int j=1;j<array.length;j++){
            key=array[j];
            i=j-1;
            while(i>=0 && array[i]<key){ //less than makes this reverse order
                array[i+1]=array[i];
                i=i-1;
            }
            array[i+1]=key;
        }
        
        //print array
        System.out.println("Sorted into non-increasing order:");
        printArray(array);
    }
    
    public static void printArray(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
}
