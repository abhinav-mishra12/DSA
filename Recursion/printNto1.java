import java.util.Scanner;

public class printNto1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        printNo(n,1);
        input.close();
    }
    public static void printNo(int i, int j){
        if (i<j) {
           return; 
        }
        else{
            System.out.print(i+" ");
            i--;
            printNo(i, j);
        }
    }
}
