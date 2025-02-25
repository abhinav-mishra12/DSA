// // You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings,
//  ruleKey and ruleValue.

// // The ith item is said to match the rule if one of the following is true:

// // ruleKey == "type" and ruleValue == typei.
// // ruleKey == "color" and ruleValue == colori.
// // ruleKey == "name" and ruleValue == namei.
// // Return the number of items that match the given rule.

 

// // Example 1:

// // Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
// // Output: 1
// // Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].

// // Example 2:

// // Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
// // Output: 2
// // Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"]
//  does not match.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class countMatches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //We create an list of lists in it
        List<List<String>> list = new ArrayList<>();

        //Initialization.
        //The loop will run 3 times, this will create 3 ArrayList inside the list
        for (int i = 0; i < 3; i++) {
            list.add(new ArrayList<>());
        }

        //Add a element
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list.get(i).add(input.nextLine());
            }
        }

        //Printing the element
        System.out.print(list);
        System.out.println();

        
        // Now define the ruleKey and ruleValue
        String ruleKey = "type";
        String ruleValue = "phone";
        

        int count = countMatches(list, ruleKey, ruleValue);
        System.out.println(count);



        input.close();

    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for(List<String> item : items){
            switch (ruleKey) {
                case "type":
                // If ruleKey is "type", check the first element of the item (item[0])

                    if (item.get(0).equals(ruleValue)) {
                        count++;
                    }
                    break;
                
                case "color":
                 // If ruleKey is "color", check the second element of the item (item[1])
                if (item.get(1).equals(ruleValue)) {
                    count++;
                }
                    break;

                case "name":
                // If ruleKey is "name", check the third element of the item (item[2])

                if (item.get(2).equals(ruleValue)) {
                    count++;
                }
                    break;
                default:
                System.out.println("Enter valid input");
                    break;
            }
        }
        return count;
        
    }
}
