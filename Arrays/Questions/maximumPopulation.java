// You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.

// The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.

// Return the earliest year with the maximum population.

 

// Example 1:

// Input: logs = [[1993,1999],[2000,2010]]
// Output: 1993
// Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
// Example 2:

// Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
// Output: 1960
// Explanation: 
// The maximum population is 2, and it had happened in years 1960 and 1970.
// The earlier year between them is 1960.

import java.util.Scanner;

public class maximumPopulation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the no of persons: ");
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] logs = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                logs[i][j]=input.nextInt();
            }
        }

        int maxYear = maximumPopulation(logs);
        System.out.println("Earliest year with maximum population is: "+ maxYear);
        
        input.close();
    }

    static int maximumPopulation(int[][] logs){
        int[] arr = new int[101];
        //PrefixSum krwana hai too mujhe birth year m +1 and death year m -1 krwana hai

        for (int[] log : logs) {
            int by = log[0];
            int dy = log[1];
            arr[by-1950]++;
            arr[dy-1950]--;
        }

        int max = arr[0];
        int maxYear = 1950;
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i-1];
            if (max<arr[i]) {
                max = arr[i];
                maxYear = 1950 + i;
            }
        }

        return maxYear;

    }
}
