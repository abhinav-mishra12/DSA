import java.util.Scanner;

public class checkPrime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(checkPrime(n));;
    }
    public static boolean checkPrime(int n){
        if (n%2==0) {
            return false;
        }
        else{
            return true;
        }
    }
}
