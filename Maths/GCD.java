//Highest common factor

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        System.out.println(checkGCD(n1,n2));
    }
    public static int checkGCD(int n1, int n2){
        while (n1>0 && n2>0) {
            if (n1>n2) {
                n1=n1%n2;
            }
            else if(n2>n1){
                n2=n2%n1;
            }
        }
        if (n1==0) {
            return n2;
        }
        return n1;

    }
}


//Brute force solution                                
// public class Main {
//     public static int findGcd(int n1, int n2) {
//         // Initialize gcd to 1
//         int gcd = 1;

//         // Iterate from 1 up to
//         // the minimum of n1 and n2
//         for (int i = 1; i <= Math.min(n1, n2); i++) {
//             // Check if i is a common
//             // factor of both n1 and n2
//             if (n1 % i == 0 && n2 % i == 0) {
//                 // Update gcd to the
//                 // current common factor i
//                 gcd = i;
//             }
//         }

//         // Return the greatest
//         // common divisor (gcd)
//         return gcd;
//     }

//     public static void main(String[] args) {
//         int n1 = 20, n2 = 15;

//         // Find the GCD of n1 and n2
//         int gcd = findGcd(n1, n2);

//         System.out.println("GCD of " + n1 + " and " + n2 + " is: " + gcd);
//     }
// }
                                
                            