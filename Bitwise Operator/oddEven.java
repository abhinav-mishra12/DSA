import java.util.Scanner;

public class oddEven{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(isOdd(n));
        input.close();
    }
    public static boolean isOdd(int n){
        if((n&1)==1){
            return true;
        }
        else{
            return false;
        }
    }
} //In binary, all odd numbers have their least significant bit (LSB) set to 1, and even numbers have their LSB set to 0