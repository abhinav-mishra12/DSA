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
        // pattern5(9);



    
   
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

    // static void pattern5(int n){
    //     for (int i = 1; i <= n; i++) {
    //         if (i<=5) {
    //             for (int j = 0; j <= i; j++) {
    //                 System.out.print("* ");
    //             }
    //             System.out.println();
    //         }
    //         else if (i>5) {
    //             for (int j = 0; j < 4; j++) {
    //                 for (int j2 = 4; j2 >j ; j2--) {
    //                     System.out.print("* ");
    //                 }
                    
    //             }
    //             System.out.println();
    //         }
    //     }
    // }
        
    
}