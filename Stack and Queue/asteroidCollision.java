// We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.

// For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

// Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

// Example 1:

// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
// Example 2:

// Input: asteroids = [8,-8]
// Output: []
// Explanation: The 8 and -8 collide exploding each other.
// Example 3:

// Input: asteroids = [10,2,-5]
// Output: [10]
// Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
import java.util.Stack;
public class asteroidCollision {
    public static void main(String[] args) {
        

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            // Handle collisions
            while (!st1.isEmpty() && st1.peek() > 0 && a < 0) {
                int top = st1.peek();
                if (Math.abs(top) < Math.abs(a)) {
                    st1.pop(); // top asteroid is destroyed, keep checking
                } else if (Math.abs(top) == Math.abs(a)) {
                    st1.pop(); // both destroy each other
                    destroyed = true;
                    break;
                } else {
                    // incoming asteroid is destroyed
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                st1.push(a);
            }
        }

        // Reverse stack to get final state
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }

        int[] result = new int[st2.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = st2.pop();
        }

        return result;
    }
}

    }
}
