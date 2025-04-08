import java.util.Scanner;

public class printNameNTimes {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        printName(n,m);
        input.close();
    }
    public static void printName(int i, int j){
        if(i>j){
            return;
        }
        else{
            System.out.println("Abhinav");
            i++;
            printName(i, j);
        }
    }
}
