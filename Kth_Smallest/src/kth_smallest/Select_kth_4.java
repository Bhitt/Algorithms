/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kth_smallest;

/**
 *
 * @author bhitt
 */
public class Select_kth_4 {
    
    int Select2(int[] arr, int n, int k){
        int r=5;
        //if n <= r then sort arr and return the kth element 
        if(n<=r){
            insertionSort(arr);
            return arr[k-1];
        }
        //divide arr into n/r subsets of size r each, ignoring excess elements
        //and let M be the set of medians
        int temp[] = new int[r];
        int M[] = new int[n/r];
        for(int i=0;i<(n/r);i++){
            //copy out a subset of size r
            for(int j=0;j<r;j++){
                temp[j] = arr[i*j];
            }
            //sort the subset
            insertionSort(temp);
            //add the median of the subset into M
            M[i] = temp[r/2];
        }        
        
        //find the median of medians
        int v = Select2(M,n/r,(n/r)/2);
        System.out.println("v:"+v);
        
        //partition using the median of medians as the pivot
        int pivotPos = 0;
        for(int i=0;i<n;i++){
            //System.out.println("arr[i]:"+i);
            if(arr[i]==v) pivotPos=i;
        }
        int m = 0;
        int j = n-1;
        pivotPos = partition(arr,m,j,pivotPos);
        
        System.out.println("pivotPos: "+pivotPos);
        
        //check for kth element
        if(k == (pivotPos+1)){
            return arr[pivotPos];
        }else if(k < (pivotPos+1)){
            //let S be the set of elements arr(1,...,pivotPos-1)
            int[] S = new int[pivotPos];
            for(int i=0;i<(pivotPos);i++){
                S[i] = arr[i];
            }
            return Select2(S,pivotPos,k);
        }else{
            //let R be the set of element arr(pivotPos+1,...,n)
            int[] R = new int[n-(pivotPos+1)];
            for(int i=0;i<(n-(pivotPos+1));i++){
                R[i]=arr[pivotPos+i];
            }
            return Select2(R,(n-(pivotPos+1)),k-(pivotPos+1));
        }
    }
    
    int partition(int arr[], int low, int high, int pivot) 
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
  
        return i+1; 
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
}
