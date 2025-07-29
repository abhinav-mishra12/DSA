// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
import java.util.*;
public class mergeIntervals {
    public static void main(String[] args) {

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Step 2: Initialize with first interval
        int[] current = intervals[0];
        result.add(current);

        // Step 3: Traverse the rest
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (current[1] >= next[0]) {
                // Overlapping — merge them
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap — move to next
                current = next;
                result.add(current);
            }
        }

        // Step 4: Convert List<int[]> to int[][]
        return result.toArray(new int[result.size()][]);
    }
}

    }
}
