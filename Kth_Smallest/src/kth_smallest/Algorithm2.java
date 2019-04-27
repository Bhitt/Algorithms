/*
    Sort the list using the partition procedure iteratively
 */
package kth_smallest;

/**
 *
 * @author bhitt
 */
public class Algorithm2 {
    
    /*procedure Algorththm#2 (A, n, k) // A is array, n is # of array, k is key
begin
m  1;
j  n;
loop
call Partition (m, j, pivotposition);
case:
k = pivotposition:
return A(k);
k < pivotposition:
j  pivotposition – 1;
else:
m  pivotposition + 1;
k  k - pivotposition;
end loop;
//end;*/
    
    int findKth(int arr[], int n, int k){
        int m = 0;
        int j = n-1;
        int pivot = k-1;
        boolean stop=false;
        while(!stop){
            partition(arr,m,j,pivot);
            if(arr[k-1] == arr[pivot]){
                stop=true;
            }else if(arr[k-1] < arr[pivot]){
                j=pivot-1;
            }else{
                m=pivot+1;
                k=k-pivot;
            }
        }
        return arr[k];
    }
    
    /* This function takes last element as pivot, 
   places the pivot element at its correct 
   position in sorted array, and places all 
   smaller (smaller than pivot) to left of 
   pivot and all greater elements to right 
   of pivot */
    void partition(int arr[], int low, int high, int pivot) 
    {  
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
  
        //return i+1; 
    }
}
