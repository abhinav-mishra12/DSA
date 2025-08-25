import java.util.*;

public class minimumNoOfTrainsRequiredForARailway {
    public static int findMinimumPlatforms(int[] arrival, int[] departure, int n) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int i = 0, j = 0;
        int platformsNeeded = 0, maxPlatforms = 0;

        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                // Train arrived before previous left
                platformsNeeded++;
                maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
                i++;
            } else {
                // Train departed
                platformsNeeded--;
                j++;
            }
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arrival.length;

        int result = findMinimumPlatforms(arrival, departure, n);
        System.out.println("Minimum number of platforms required = " + result);
    }
}
