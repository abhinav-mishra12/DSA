import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListExample {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        //Syntax
        ArrayList<Integer> list = new ArrayList<>(5);
        list.add(66);
        list.add(23);
        list.add(45);
        list.add(78);
        list.add(65);
        list.add(21);
        System.out.println(list);
        list.set(0, 99);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);

        for (int i = 0; i < 5; i++) {
            list.add(input.nextInt());
        }
        for (int j = 0; j < 5; j++) {
            System.out.println(list.get(j));
        }

        input.close();
    }
}
