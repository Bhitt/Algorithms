/*
    Towers of Hanoi
-A classical recursion problem based on a simple game. 
-The game has 3 posts with a stack of different-diameter disks on one of them(leftmost one).
-The game is to move all the disks to the rightmost post according to the following rules:

(Rule#1) No disk can ever be on top of a disk that is smaller
(Rule#2) Only one disk can be moved at a time
(Rule#3) A disk must always be placed on one tower, never off to the side
(Rule#4) Only the disk at the top of a tower can be moved, never a lower one.

*/

/*
Time complexity:
    Analysis of Recursion
    Recursive Equation : T(n) = 2T(n-1) + 1 ——-equation-1

    Solving it by BackSubstitution :
    T(n-1) = 2T(n-2) + 1 ———–equation-2
    T(n-2) = 2T(n-3) + 1 ———–equation-3

    Put value of T(n-2) in equation–2 with help of equation-3
    T(n-1)= 2( 2T(n-3) + 1 ) + 1 ——equation-4

    Put value of T(n-1) in equation-1 with help of equation-4
    T(n)= 2( 2( 2T(n-3) + 1 ) + 1 ) + 1 
    T(n) = 2^3 T(n-3) + 2^2 + + 2^1 + 1 

    After Generalization :
    T(n)=  2^k T(n-k) + 2^{(k-1)} + + 2^{(k-2)} + ............ +2^2 + + 2^1 + 1

    Base condition T(0) == 1
    n – k = 0
    n = k;
    put, k = n
    T(n) = 2^n T(0) + 2^{(n-1)} + + 2^{(n-2)} + ............ +2^2 + + 2^1 + 1

    It is GP series, and sum is 2^{(n+1)} - 1

    T(n)= O( 2^{(n+1)} - 1), or you can say O(2^n) which is exponentioal
 */
package towers_of_hanoi;

import java.util.Scanner;

/**
 *
 * @author bhitt
 */
public class Towers_of_Hanoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Integer numDisks;
        System.out.println("How many disks are on the first tower?");
        Scanner scanner = new Scanner(System. in); 
        numDisks = scanner.nextInt();
        moveDisks(numDisks, "Tower A", "Tower C ", "Tower B");
    }

    public static void moveDisks(int n, String fromTower, String toTower, String auxTower)
    {
      if (n == 1)
         System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
      else
      {
         moveDisks(n-1, fromTower, auxTower, toTower);

         System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);

         moveDisks(n-1, auxTower, toTower, fromTower);
       }
    }
    
}
