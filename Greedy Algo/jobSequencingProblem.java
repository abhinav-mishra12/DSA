import java.util.*;

class Job {
    int id, deadline, profit;
    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class jobSequencingProblem {
    public static void jobScheduling(Job[] jobs, int n) {
        // Sort jobs by profit (descending)
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Array to store result slots (-1 means free)
        int[] result = new int[maxDeadline + 1];
        Arrays.fill(result, -1);

        int jobCount = 0, totalProfit = 0;

        // Place each job
        for (Job job : jobs) {
            // Try to put job at its deadline or before
            for (int j = job.deadline; j > 0; j--) {
                if (result[j] == -1) {
                    result[j] = job.id;
                    jobCount++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        // Print result
        System.out.print("Jobs done: ");
        for (int i = 1; i <= maxDeadline; i++) {
            if (result[i] != -1) {
                System.out.print("J" + result[i] + " ");
            }
        }
        System.out.println("\nTotal Jobs = " + jobCount);
        System.out.println("Total Profit = " + totalProfit);
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        };

        int n = jobs.length;
        jobScheduling(jobs, n);
    }
}
