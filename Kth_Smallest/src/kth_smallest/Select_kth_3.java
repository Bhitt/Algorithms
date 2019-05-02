/*
Select_kth_3: Use the partition method of quicksort recursively until the
              kth element is in the pivot position after partitioning.
              Then return the kth element.
 */
package kth_smallest;

/**
 *
 * @author bhitt
 */
public class Select_kth_3 {
    //
    int findKth(int arr[], int n, int k){
        int m = 0;
        int j = n-1;
        int pivotPos = 0;
        pivotPos = partition(arr,m,j,k);
        return arr[pivotPos];
    }
    
    //
    int partition(int arr[], int low, int high, int k) 
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
  
        pivot = i+1;
        
        if(k == (pivot+1)){
            return pivot;
        }else if(k < (pivot+1)){
            high=pivot-1;
            return partition(arr,low,high,k);
        }else{
            low=pivot+1;
            //k=k-(pivot+1);
            return partition(arr,low,high,k);
        }
    }
}
