/*
 * Linear: a class implementing a linear approach to solve matrix multiplication
 *      -T(n) = O(n^3)     
 */
package dividenconquer_matrixmult;

/**
 *
 * @author bhitt
 */
public class Linear {
    public int[][] multiplyMatrix(int[][]matrixA,int[][]matrixB){
        //get the matrix size
        int size = matrixA.length;
        //create a new matrix to return
        int[][]matrixC = new int[size][size];
        //beginning looping
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                //set matrixC element to 0
                matrixC[i][j] = 0;
                for(int k=0;k<size;k++){
                    matrixC[i][j] = matrixC[i][j]+matrixA[i][k]*matrixB[k][j];
                }
            }
        }
        return matrixC;
    }
}
