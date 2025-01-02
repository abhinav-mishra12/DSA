import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

       String fruit = input.next();

       switch (fruit) {
           case "Mango" -> System.out.println("King of fruits");
           case "Apple" -> System.out.println("A sweet red fruit");
           case "Orange" -> System.out.println("Round fruit");
           case "Grapes" -> System.out.println("Small fruit");
           default -> System.out.println("please enter a valid fruit");
       }

        int day = input.nextInt();
       switch (day) {
           case 1 -> System.out.println("Monday");
           case 2 -> System.out.println("Tuesday");
           case 3 -> System.out.println("Wednesday");
           case 4 -> System.out.println("Thursday");
           case 5 -> System.out.println("Friday");
           case 6 -> System.out.println("Saturday");
           case 7 -> System.out.println("Sunday");
       }

       switch (day) {
           case 1:
           case 2:
           case 3:
           case 4:
           case 5:
               System.out.println("Weekday");
               break;
           case 6:
           case 7:
               System.out.println("Weekend");
               break;
       }

        switch (day) {
            case 1, 2, 3, 4, 5 -> System.out.println("Weekday");
            case 6, 7 -> System.out.println("Weekend");
        }

        // Nested Switch
        int empID = input.nextInt();
        String department = input.next();

        switch (empID) {
            case 1:
                System.out.println("Kunal Kushwaha");
                break;
            case 2:
                System.out.println("Rahul Rana");
                break;
            case 3:
                System.out.println("Emp Number 3");
                switch (department) {
                    case "IT":
                        System.out.println("IT Department");
                        break;
                    case "Management":
                        System.out.println("Management Department");
                        break;
                    default:
                        System.out.println("No department entered");
                }
                break;
            default:
                System.out.println("Enter correct EmpID");
        }

        // better way to write
        switch (empID) {
            case 1 -> System.out.println("Kunal Kushwaha");
            case 2 -> System.out.println("Rahul Rana");
            case 3 -> {
                System.out.println("Emp Number 3");
                switch (department) {
                    case "IT" -> System.out.println("IT Department");
                    case "Management" -> System.out.println("Management Department");
                    default -> System.out.println("No department entered");
                }
            }
            default -> System.out.println("Enter correct EmpID");
        }
        input.close();
    }
}
