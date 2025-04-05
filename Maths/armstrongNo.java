// Check armstrong no means 786==(7*7*7)+(8*8*8)+(6*6*6)

import java.util.Scanner;

// import javax.swing.plaf.synth.SynthStyle;

public class armstrongNo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(checkArmstrong(n));
        input.close();
    }
    public static boolean checkArmstrong(int n){
        int original=n;
        int sum=0;
        int lastdigit;

        while(n!=0){
            lastdigit=n%10;
            sum=(int) (sum+Math.pow(lastdigit,3));
            n=n/10;
        }

        if (sum==original) {
            return true;
        }
        else{
            return false;
        }
    }
}
