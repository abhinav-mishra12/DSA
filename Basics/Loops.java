import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Print numbers from 1 to n 
        System.out.print("Enter till where do you want to get the numbers printed: ");
        int n = input.nextInt();
        for(int num=1; num<=n; num++){
            System.out.println(num);
        }

        // do while
        // do{

        // }
        // while(condition);

        // Q: Find the largest of the 3 numbers
        System.out.println("Enter the three numbers: ");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        int max = a;
        if (b>max) {
            max=b;
        }
        else if (c>max) {
            max=c;
        }
        System.out.println(max);

        //Q: Alphabet case check 
        System.out.print("Enter the input string: ");
        char ch = input.next().trim().charAt(0);
        if(ch>='a' && ch<='z'){
            System.out.println("Lower Case");
        }
        else{
            System.out.println("Upper Case");
        }

        //Q: Fibbonacci numbers
        int num1=0;
        int num2=1;
        System.out.println("Enter the value of N");
        int N = input.nextInt();
        System.out.println(num1);
        System.out.println(num2);
        for(int i=2; i<=N; i++){
            int num = num1+num2;
            num1=num2;
            num2=num;
            System.out.println(num);
        }

        //Q: Counting the occurences of 7
        int number=13857879;
        int count = 0;
        while (number>0) {
            int rem = number%10;  // Kisi bhi number ka last digit lene k liye %10
            if (rem==7) {
                count++;
            }
            number=number/10;     // Kisi bhi int number ki last digit hatane k liye / 10 
        }
        System.out.println(count);

        //Q: Reverse the number
        int number2=23597;
        while (number2>0) {
            int remainder= number2%10;
            System.out.print(remainder);
            number2=number2/10;
        }
    
        input.close();
    }
}
