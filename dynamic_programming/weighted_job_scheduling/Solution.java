package dynamic_programming.weighted_job_scheduling;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        if (n == 0)
            return 0;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        //sorting them based on their end time
        jobs.sort(Comparator.comparingInt(a -> a.end));
        int[] dp = new int[n];
        int ans = 0;
        // By Default we will select each job
        for (int i = 0; i < n; i++) {
            dp[i] = jobs.get(i).profit;
            ans = Math.max(ans, dp[i]);
        }
        //we are making choice at every job, whether to choose or not
        for (int i = 1; i < n; i++) {
            //including current job
            // we will look for last possible job that can be done just before current using bs
            int prevIndex = getPrevJob(i, jobs);
            if (prevIndex != -1) {
                dp[i] += dp[prevIndex];
            }
            //excluding current job
            dp[i] = Math.max(dp[i], dp[i - 1]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int getPrevJob(int currentIndex, List<Job> jobs) {
        Job current = jobs.get(currentIndex);
        int low = 0;
        int high = currentIndex;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            Job prev = jobs.get(mid);
            if (prev.end <= current.start) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;

        }
        return ans;
    }

    public static class Job {
        int start;
        int end;
        int profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}