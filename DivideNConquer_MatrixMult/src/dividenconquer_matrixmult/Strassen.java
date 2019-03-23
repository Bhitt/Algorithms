/*
 * Strassen: a class implementing methods of Strassen's matrix multiplication
 *      -T(n) = 7T(n/2) + O(n^2)   if n>1
              = O(1)               if n=1
        -T(n) = O(n^lg7)
              = O(n^2.81)
 */
package dividenconquer_matrixmult;

/**
 *
 * @author bhitt
 */
public class Strassen {
    //recursive method used to multiply the matrices
    public int[][] multiplyMatrix(int[][]matrixA, int[][]matrixB){
        //find the size of input matrices
        int size=matrixA.length;
        //System.out.println("matrix size: "+size);
        int[][]matrixC = new int[size][size];
        //solve for the base case
        if(size==1){
            matrixC[0][0] = matrixA[0][0]*matrixB[0][0];
        }
        else{
            //create 8 new arrays to hold the sub arrays
            int[][]matrixA11 = new int[size/2][size/2];
            int[][]matrixA12 = new int[size/2][size/2];
            int[][]matrixA21 = new int[size/2][size/2];
            int[][]matrixA22 = new int[size/2][size/2];
            int[][]matrixB11 = new int[size/2][size/2];
            int[][]matrixB12 = new int[size/2][size/2];
            int[][]matrixB21 = new int[size/2][size/2];
            int[][]matrixB22 = new int[size/2][size/2];
            //divide the first matrix into 4 parts
            schism(matrixA, matrixA11, 0, 0);
            schism(matrixA, matrixA12, 0, size/2);
            schism(matrixA, matrixA21, size/2, 0);
            schism(matrixA, matrixA22, size/2, size/2);
            //divide the second matrix into 4 parts
            schism(matrixB, matrixB11, 0, 0);
            schism(matrixB, matrixB12, 0, size/2);
            schism(matrixB, matrixB21, size/2, 0);
            schism(matrixB, matrixB22, size/2, size/2);
            
            //7 multiplication calls
            int [][]mult1 = multiplyMatrix(add(matrixA11,matrixA22),add(matrixB11,matrixB22));      //mult1 = (A11+A22)(B11+B22)
            int [][]mult2 = multiplyMatrix(add(matrixA21,matrixA22), matrixB11);                    //mult2 = (A21+A22)B11
            int [][]mult3 = multiplyMatrix(matrixA11,subtract(matrixB12,matrixB22));                //mult3 = A11(B12-B22)
            int [][]mult4 = multiplyMatrix(matrixA22,subtract(matrixB21,matrixB11));                //mult4 = A22(B21-B11)
            int [][]mult5 = multiplyMatrix(add(matrixA11,matrixA12),matrixB22);                     //mult5 = (A11+A12)B22
            int [][]mult6 = multiplyMatrix(subtract(matrixA21,matrixA11),add(matrixB11,matrixB12)); //mult6 = (A21-A11)(B11+B12)
            int [][]mult7 = multiplyMatrix(subtract(matrixA12,matrixA22),add(matrixB21,matrixB22)); //mult7 = (A12-A22)(B21+B22)
            
            //use the mults and place them into pieces of matrixC
            int [][]matrixC11 = add(subtract(add(mult1,mult4),mult5),mult7);    //C11 = mult1 + mult4 - mult5 + mult7
            int [][]matrixC12 = add(mult3,mult5);                               //C12 = mult3 + mult5
            int [][]matrixC21 = add(mult2, mult4);                              //C21 = mult2 + mult4
            int [][]matrixC22 = add(subtract(add(mult1, mult3),mult2),mult6);   //C22 = mult1 + mult3 - mult2 + mult6
            
            //I know the pieces fit, cuz i watched them fall away  (rejoin the pieces of matrixC into matrixC)
            fit(matrixC11, matrixC, 0, 0);
            fit(matrixC12, matrixC, 0, size/2);
            fit(matrixC21, matrixC, size/2, 0);
            fit(matrixC22, matrixC, size/2, size/2); 
        }
        //enter frankenstein (return the product)
        return matrixC;
    }
    
    //split part of the input oldMatrix and place it into the newMatrix
    public void schism(int[][] oldMatrix, int[][] newMatrix, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < newMatrix.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < newMatrix.length; j1++, j2++)
                newMatrix[i1][j1] = oldMatrix[i2][j2];
    }
    
    //add two matrices together
    public int[][] add(int[][] matrixA, int[][] matrixB)
    {
        int size = matrixA.length;
        int[][] matrixC = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
        return matrixC;
    }
    
    //subtract matrixB from matrixA
    public int[][] subtract(int[][] matrixA, int[][] matrixB)
    {
        int size = matrixA.length;
        int[][] matrixC = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                matrixC[i][j] = matrixA[i][j] - matrixB[i][j];
        return matrixC;
    }
    
    //put the new pieces back into the old matrix
    public void fit(int[][] newMatrix, int[][] oldMatrix, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < newMatrix.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < newMatrix.length; j1++, j2++)
                oldMatrix[i2][j2] = newMatrix[i1][j1];
    }
}
