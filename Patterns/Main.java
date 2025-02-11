public class Main {

    public static void main(String[] args) {
      
        //   Q1: *****
        //       *****
        //       *****
        //       *****
        //       *****
        pattern1(5);

        
        
        // Q2: *
        //     **
        //     ***
        //     ****
        //     *****
        pattern2(5);

        
        
        // Q3:  *****
        //      ****
        //      ***
        //      **
        //      *
        pattern3(5);


       
        //   Q4. 1
        //       1 2 
        //       1 2 3 
        //       1 2 3 4 
        //       1 2 3 4 5
        pattern4(5);

       
       
        // Q5: *
        //     **
        //     ***
        //     ****
        //     *****
        //     ****
        //     ***
        //     **
        //     *
        pattern5(5);



        // Q6:    
        //      *
        //     * *
        //    * * *
        //   * * * *
        //  * * * * *
        //   * * * *
        //    * * *
        //     * *
        //      *

         pattern6(5);

        
        
        
         // Q7:
        //            1
        //          2 1 2
        //        3 2 1 2 3
        //      4 3 2 1 2 3 4
        //    5 4 3 2 1 2 3 4 5
        pattern7(5);



        //Q8: 
        //      1
        //     212
        //    32123
        //   4321234
        //    32123
        //     212
        //      1
        pattern8(4);


        
        
        //Q9:
        // 4 4 4 4 4 4 4  
        // 4 3 3 3 3 3 4   
        // 4 3 2 2 2 3 4   
        // 4 3 2 1 2 3 4   
        // 4 3 2 2 2 3 4   
        // 4 3 3 3 3 3 4   
        // 4 4 4 4 4 4 4
        pattern9(4);




        


        



    
   
    }

    static void pattern1(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for (int i = 0; i < n; i++) {
            for (int j = n; j >=i ; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }

    static void pattern5(int n){
        
        // Upper part of the pattern
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower part of the pattern
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    static void pattern6(int n){
        
        //Print the upper half of the diamond
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" "); // Print Spaces
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        //Print the lower half of the diamond
        for (int i = n-1; i >= 1; i--) {
            for (int j = i; j < n; j++) {
                System.out.print(" "); //Print Spaces
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern7(int n){
        for (int row = 1; row <= n; row++) {

            //For Spaces
            for (int spaces = 0; spaces < n-row; spaces++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1; col--) {
                System.out.print(col+" "); // For printing col from row no to 1
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col+" "); // For printing col from 2 to row no
            }
            System.out.println();
        }
    }

    static void pattern8(int n){

        // For upper half
       for (int row = 1; row <= n; row++) {
        for (int j = row; j < 4; j++) {
            System.out.print(" ");
        }
        for (int col = row; col >= 1; col--){
            System.out.print(col);
        }
        for (int col = 2; col <= row; col++) {
            System.out.print(col);
        }
        System.out.println();
       } 

       // For lower half
       for (int row = 3; row >= 1; row--) {
        for (int i = row; i < 4; i++) {
            System.out.print(" ");
        }
        for (int col = row; col >= 1; col--) {
            System.out.print(col);
        }
        for (int col = 2; col <= row; col++) {
            System.out.print(col);
        }
        System.out.println();
       }

    }

    static void pattern9(int n){
        int original = n;
        n=2*n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int atEveryIndex=original-Math.min(Math.min(row, col), Math.min(n-row, n-col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }

    
}