// There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.

// You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.

 

// Example 1:

// Input: gain = [-5,1,5,0,-7]
// Output: 1
// Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
// Example 2:

// Input: gain = [-4,-3,-2,-1,4,3,2]
// Output: 0
// Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class largestAltitude {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            list.add(input.nextInt());
        }
        System.out.print(list);

        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=list.get(i);
        }

        System.out.print(Arrays.toString(nums));

        int ans = largestAltitude(nums);
        System.out.println(ans);


        input.close();
    }
    public static int largestAltitude(int[] gain) {
        int[] answer = new int[gain.length+1];
        answer[0]=0;
        int highest = answer[0];
        for (int i = 1; i < answer.length; i++) {
            answer[i]=answer[i-1]+gain[i-1];
        }

        for (int i = 0; i < answer.length; i++) {
            if (answer[i]>highest) {
                highest=answer[i];
            }
        }



        return highest;
    }
}
