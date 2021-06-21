package greedy;

import java.util.ArrayList;
import java.util.List;

public class MaxMeetings {

    public static void main(String[] args) {

        ArrayList<Meeting> input = new ArrayList<>(List.of(
                new Meeting(0, 2),
                new Meeting(2, 4),
                new Meeting(3, 4),
                new Meeting(1, 6),
                new Meeting(7, 8),
                new Meeting(6, 8),
                new Meeting(8, 9),
                new Meeting(8, 9)
        ));

        System.out.println(maxMeetings(input));
    }

    public static int maxMeetings(List<Meeting> meetings) {

        if (meetings == null || meetings.size() == 0)
            return 0;

        meetings.sort((a, b) -> {
            return (a.getEndTime() - b.getEndTime() != 0) ?
                    a.getEndTime() - b.getEndTime() : a.getStartTime() - b.getStartTime();
        });
        int count = 1;
        Meeting current = meetings.get(0);
        current.print();
        for (Meeting meeting : meetings) {
            if (meeting.getStartTime() >= current.getEndTime()) {
                meeting.print();
                current = meeting;
                count++;

            }
        }

        return count;
    }
}
