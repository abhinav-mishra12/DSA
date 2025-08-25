import java.util.*;

class Meeting {
    int start, end, pos;
    Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

public class nMeetingsInARoom {
    public static void maxMeetings(int[] start, int[] end, int n) {
        List<Meeting> meetings = new ArrayList<>();

        // Store all meetings with start, end, and position
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }

        // Sort by end time
        meetings.sort((a, b) -> a.end - b.end);

        List<Integer> result = new ArrayList<>();
        int lastEnd = -1; // track when last meeting finished

        for (Meeting m : meetings) {
            if (m.start > lastEnd) {
                result.add(m.pos);
                lastEnd = m.end;
            }
        }

        // Print selected meetings
        System.out.println("Meetings that can be scheduled: " + result);
        System.out.println("Maximum meetings = " + result.size());
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 6, 7, 9, 9};
        int n = start.length;

        maxMeetings(start, end, n);
    }
}
