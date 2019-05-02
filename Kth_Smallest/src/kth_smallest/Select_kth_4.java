/*
Select_kth_4: Find the median of medians(MM), then use the MM as the pivot
              for the partitioning method of quick sort. Once the kth element
              is in the pivot position after partitioning, return the kth
              element.
 */
package kth_smallest;

/**
 *
 * @author bhitt
 */
public class Select_kth_4 {
    
    int Select2(int[] arr, int n, int k){
        //Each subset will be of size r
        int r=5;
        //if n <= r then sort arr and return the kth element 
        if(n<=r){
            insertionSort(arr);
            return arr[k-1];
        }
        //divide arr into n/r subsets of size r each, ignoring excess elements
        //and let M be the set of medians
        int temp[] = new int[r];
        int M[] = new int[((int)Math.floor(n/r))];
        for(int i=0;i<M.length;i++){
            //copy out a subset of size r
            for(int j=0;j<r;j++){
                temp[j] = arr[(i*r)+j];
            }
            //sort the subset
            insertionSort(temp);
            //add the median of the subset into M
            M[i] = temp[((int)Math.ceil(r/2))];
        }
        
        //find the median of medians
     int v = Select2(M,(int)Math.floor(n/r),(int)Math.ceil(Math.floor(n/r)/2));
        
        //partition using the median of medians as the pivot
        int pivotPos = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==v) pivotPos=i;
        }
        
        int m = 0;
        int j = n-1;
        pivotPos = partition(arr,m,j,pivotPos);
        
        //check for kth element
        if(k == (pivotPos+1)){
            //if the pivot is at the kth position, return the kth element
            return arr[pivotPos];
        }else if(k < (pivotPos+1)){
            //If the pivot is greater than k, call Select2 on the bottom half
            //      of the array below the pivot.
            //let S be the set of elements arr(1,...,pivotPos-1)
            int[] S = new int[pivotPos];
            for(int i=0;i<S.length;i++){
                S[i] = arr[i];
            }
            return Select2(S,S.length,k);
        }else{
            //If the pivot is less than k, call Select2 on the top half
            //      of the array below the pivot.
            //let R be the set of element arr(pivotPos+1,...,n)
            int[] R = new int[n-(pivotPos+1)];
            for(int i=0;i<(n-(pivotPos+1));i++){
                R[i]=arr[pivotPos+1+i];
            }
            return Select2(R,R.length,k-(pivotPos+1));
        }
    }
    
     int partition(int[] array, int low, int high, int pivot){
        //
        swap(array, low, pivot);
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
    
    void insertionSort(int arr[]){
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    }
    
    void printArray(int[] arr,int size){
        for(int i=0;i<size;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
