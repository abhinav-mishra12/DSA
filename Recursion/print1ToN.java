import java.util.Scanner;

public class print1ToN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        printNos(1, n);  // Start the count from 1
        input.close();
    }

    public static void printNos(int count, int n) {
        if (count > n) { // Base case: when count exceeds n, stop
            return;
        } else {
            System.out.print(count + " ");
            printNos(count + 1, n);  // Pass the incremented count to the next recursive call
        }
    }
}
