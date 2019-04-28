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
        int k=13;
        int ans=0;
        //Initialize list of elements to be sorted and searched
        
        //size n = 10
        int[] array10 = {3,5,4,1,6,7,2,9,8,10};
        
        int[] array25 = {1,12,22,15,5,6,18,8,9,21,
                         11,2,13,14,4,16,17,7,19,20,
                         10,3,23,24,25};
        
        int[] array100 = {3, 20, 90, 62, 1, 84, 96, 42, 64, 33,
                          79, 46, 59, 75, 76, 48, 45, 15, 95, 99,
                          86, 39, 30, 24, 61, 25, 38, 28, 72, 10,
                          69, 58, 87, 57, 32, 34, 41, 40, 43, 52,
                          74, 91, 51, 77, 63, 94, 78, 50, 65, 21,
                          27, 35, 29, 11, 54, 7, 44, 14, 100, 22,
                          13, 60, 73, 2, 18, 71, 98, 88, 68, 4, 
                          93, 36, 97, 31, 9, 47, 37, 26, 12, 17,
                          19, 83, 23, 67, 80, 82, 66, 56, 8, 92, 
                          70, 89, 53, 5, 16, 85, 81, 6, 49, 55};
        
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
        ans = select4.Select2(array25, array25.length, k);
        
        //Output the kth smallest element
        System.out.println("The kth(k="+k+") smallest element is "+ans);
        
    }
    
}
