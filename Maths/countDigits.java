//Given an integer N, return the number of digits in N.

import java.util.Scanner;

public class countDigits{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(countDigits(n));
        input.close();
    }
    public static int countDigits(int n){
        int count=0;
        while(n>0){
            n=n/10;
            count++;
        }
        return count;
    }
}