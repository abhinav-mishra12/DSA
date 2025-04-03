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
} 