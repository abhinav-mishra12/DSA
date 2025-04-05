import java.util.Scanner;

public class iBitOfNo {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n = input.nextInt();
        //Find the i(5) bit of a number 10110110(183)
        System.out.println(ithBit(n));
    }
    public static int ithBit(int n){
        
       return (n&(1<<(5-1)))!=0?1:0;
    }
}