package beautiful_numbers;

public class TaskSolution {

    public static void main(String[] args) {

        int[][] tasks = new int[][]{{2, 8}, {4, 5}, {5, 1}};
        System.out.println(solve(tasks.length, 16, tasks, 0));
    }

    public static int solve(int n, int t, int[][] tasks, int taskCount) {
        if (n == 0)
            return t >= tasks[0][0] ? taskCount : Integer.MIN_VALUE;
        else if (t <= 0)
            return Integer.MIN_VALUE;
        return Math.max(
                solve(n, t - tasks[n - 1][0] - tasks[n - 1][1], tasks, taskCount + 1),
                solve(n - 1, t, tasks, taskCount)
        );
    }
}
