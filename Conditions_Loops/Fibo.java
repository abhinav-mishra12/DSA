package Conditions_Loops;

import java.util.Scanner;

public class Fibo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = 0;
        int b = 1;
        int count = 2;
        System.out.println(a);
        System.out.println(b);

        while (count <= n) {
            int temp = b;
            b = b + a;
            a = temp;
            count++;
            System.out.println(a+b);
        }

        in.close();
    }
}