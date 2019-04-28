/*

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
    int partition(int arr[], int low, int high) 
    {  
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    }
    
    void printArray(int[] arr,int size){
        for(int i=0;i<size;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
