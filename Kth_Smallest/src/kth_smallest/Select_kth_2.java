/*
Select_kth_2: Use the partition method of quicksort iteratively until
              the kth element is in the pivot position after partitioning.
              Then return the kth element.
 */
package kth_smallest;

/**
 *
 * @author bhitt
 */
public class Select_kth_2 {
    //
    int findKth(int arr[], int n, int k){
        int m = 0;
        int j = n-1;
        int pivotPos = 0;
        boolean stop=false;
        while(!stop){
            pivotPos = partition(arr,m,j);
            if(k == (pivotPos+1)){
                stop=true;
            }else if(k < (pivotPos+1)){
                j=pivotPos-1;
            }else{
                m=pivotPos+1;
            }
        }
        return arr[pivotPos];
    }
    //
    int partition(int[] array, int low, int high){
        //
        swap(array, low, high);
        int border = low +1;
        for(int i=border; i<= high; i++){
            if(array[i] < array[low]){
                swap(array, i , border++);
            }
        }
        swap(array, low, border-1);
        return border-1;
    }
     
    void swap(int[] array, int index1, int index2){
        int temp =  array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
    void printArray(int[] arr,int size){
        for(int i=0;i<size;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
