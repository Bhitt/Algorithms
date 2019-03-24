/*
 * Divide and Conquer Matrix Multiplication analysis
 *      Purpose: run three separate methods of matrix multiplication and analyze
 *               their differences
 */
package dividenconquer_matrixmult;

import java.util.Random;

/**
 *
 * @author bhitt
 */
public class DivideNConquer_MatrixMult {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //set size of matrices
        int size=(int) Math.pow(2,11);
        //create matrix A
        //int[][]matrixA = randNumMatrix(size);
        int[][]matrixA = setNumMatrix(size);
        //output matrix A
//        System.out.println("Matrix A: ");
//        printMatrix(size,matrixA);
        //create matrix B
        //int[][]matrixB = randNumMatrix(size);
        int[][]matrixB = setNumMatrix(size);
        //output matrix B
//        System.out.println("Matrix B: ");
//        printMatrix(size,matrixB);

        //Start the timer
        long startTime = System.nanoTime();
        
        //*****************************************//
        //           Linear method                 //
        //*****************************************//
        System.out.println("Using a linear method");
        System.out.println("************************");
        Linear l = new Linear();
        int[][]matrixC = l.multiplyMatrix(matrixA, matrixB);
        
        //*****************************************//
        //         Divide and Conquer              //
        //*****************************************//
//        System.out.println("Using a divide-and-conquer Method");
//        System.out.println("************************");
//        DivideNConquer d = new DivideNConquer();
//        int[][]matrixC = d.multiplyMatrix(matrixA, matrixB);
        
        //*****************************************//
        //        Strassen's Method  (1)           //
        //*****************************************//
//        System.out.println("Using Strassen's Method (Base case n=1)");
//        System.out.println("************************");
//        Strassen s = new Strassen();
//        int[][]matrixC = s.multiplyMatrix(matrixA, matrixB);
        
        //*****************************************//
        //        Strassen's Method  (2)           //
        //*****************************************//
//        System.out.println("Using Strassen's Method (Base case n=2)");
//        System.out.println("************************");
//        Strassen_Leaf2 s2 = new Strassen_Leaf2();
//        int[][]matrixC = s2.multiplyMatrix(matrixA, matrixB);
        
        
        //Find the final time
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        
        //print final matrix
        System.out.println("Finished computing");
        System.out.println("Execution time in nanaseconds: "+ timeElapsed);
        System.out.println("Execution time in milliseconds: "+ timeElapsed/1000000);
        System.out.println("Execution time in seconds: "+ timeElapsed/1000000000);
//        System.out.println("Matrix C (Product of A & B):");
//       printMatrix(size, matrixC);
        
    }
    
    //method to print the given matrix
    public static void printMatrix(int size, int[][]matrix){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
    }
    
    //method to create a matrix with random numbers
    public static int[][] randNumMatrix(int size){
        //intialize random tool
        Random rand = new Random();
        //create matrix with random numbers from 0-9
        int[][]matrix = new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }
    
    //method to create a matrix with a specific number in for all elements
    public static int[][] setNumMatrix(int size){
        //specific number for all elements
        int number=3;
        //create matrix with a set number
        int[][]matrix = new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                matrix[i][j] = number;
            }
        }
        return matrix;
    }
    
}
