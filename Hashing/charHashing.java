//ASCII values for only lowercase alphabets thats why only array of 26 size 
import java.util.Scanner;

public class charHashing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        //pre compute
        int[] hash = new int[26];
        for (int i = 0; i < hash.length; i++) {
            hash[i]=0;
        }
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a']++;
        }

        int q = input.nextInt();
        while (q!=0) {
            char c = input.next().charAt(0);
            System.out.println(hash[c-'a']);
            q--;

        }
    }
}



// ASCII 256 values
// import java.util.Scanner;

// public class charHashing {
//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);
//         String s = input.nextLine();

//         //pre compute
//         int[] hash = new int[256];
//         for (int i = 0; i < hash.length; i++) {
//             hash[i]=0;
//         }
//         for (int i = 0; i < s.length(); i++) {
//             hash[s.charAt(i)]++;
//         }

//         int q = input.nextInt();
//         while (q!=0) {
//             char c = input.next().charAt(0);
//             System.out.println(hash[c]);
//             q--;

//         }
//     }
// }
