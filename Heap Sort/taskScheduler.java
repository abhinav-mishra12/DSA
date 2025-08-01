// You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

// Return the minimum number of CPU intervals required to complete all tasks.

 

// Example 1:

// Input: tasks = ["A","A","A","B","B","B"], n = 2

// Output: 8

// Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

// After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

// Example 2:

// Input: tasks = ["A","C","A","B","D","B"], n = 1

// Output: 6

// Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

// With a cooling interval of 1, you can repeat a task after just one other task.

// Example 3:

// Input: tasks = ["A","A","A", "B","B","B"], n = 3
import java.util.Arrays;

public class taskScheduler {
    public static void main(String[] args) {
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task-'A']++;
        }

        Arrays.sort(freq);
        int maxFreq = freq[25];
        int maxCount = 1;
        for(int i = 24; i>=0; i--){
            if(freq[i]==maxFreq){
                maxCount++;
            }
            else{
                break;
            }
        }

        int partCount = maxFreq-1;
        int partLength = n+1;
        int emptySlots = partCount*partLength+maxCount;
        return Math.max(tasks.length, emptySlots);
    }
}
    }
}
