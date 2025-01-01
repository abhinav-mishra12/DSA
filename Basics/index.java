import java.util.Scanner;
class index{
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name= input.nextLine();
        System.out.println("Hello "+ name);

        //Sum of two numbers
        System.out.println("Enter the first digit");
        int num1 = input.nextInt();
        System.out.println("Enter the second digit");
        int num2 = input.nextInt();
        int sum = num1+num2;
        System.out.println("The sum of the given two numbers is: "+ sum);

    }
}