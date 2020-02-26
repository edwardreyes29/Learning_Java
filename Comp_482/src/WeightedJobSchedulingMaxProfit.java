import java.util.Arrays;
import java.util.Comparator;

/**
 * Given set of jobs with start and end interval and profit, how to maximize profit such that
 * jobs in subset do not overlap.
 */
public class WeightedJobSchedulingMaxProfit {
    /**
     * Sort the jobs by finish time.
     * For every job find the first job which does not overlap with this job
     * and see if this job profit plus profit till last non-overlapping job is greater
     * than profit till last job
     *
     * Takes an array of jobs as parameter
     * <T> specifically stand for generic type.
     *      A generic type is a generic class or interface that is parameterized over types.
     *
     * @param jobs
     * @return
     */
    public int maximum(Job[] jobs) {
        int T[] = new int[jobs.length];
        FinishTimeComparator comparator = new FinishTimeComparator();
        /**
         * Sort array of objects according to the order induces by the comparator.
         * All element must be mutually comparable by specified comparator
         */
        for (int i = 0; i < jobs.length; i++) {
            System.out.print(jobs[i].end + " ");
        }
        System.out.println();
        Arrays.sort(jobs, comparator);
        for (int i = 0; i < jobs.length; i++) {
            System.out.print(jobs[i].end + " ");
        }
        System.out.println();

        T[0] = jobs[0].profit; // Get profit of the first job
        for (int i = 1; i < jobs.length; i++) {
            T[i] = Math.max(jobs[i].profit, T[i - 1]); // Compares profit of next job and previous job
            for(int j = 0; j < i; j++){
                if (jobs[j].end <= jobs[i].start) { // If it jbos do not overlap
                    T[i] = Math.max(T[i], jobs[i].profit + T[j]);

                }
            }
        }
        int maxVal = Integer.MIN_VALUE;
        for (int val: T) {
            if (maxVal < val) {
                maxVal = val;
            }
        }
        return maxVal;
    } // end maximum()

    public static void main(String args[]) {

        Job jobs[] = new Job[6];
        jobs[0] = new Job(5,8,11);
        jobs[1] = new Job(2, 5, 6);
        jobs[2] = new Job(4, 6, 5);
        jobs[3] = new Job(6,7,4);
        jobs[4] = new Job(1, 3, 5);
        jobs[5] = new Job(7,9,2);

        WeightedJobSchedulingMaxProfit mp = new WeightedJobSchedulingMaxProfit();
        System.out.println(mp.maximum(jobs));

    } // end main()
}

// Created Job class
class Job {
    int start;
    int end;
    int profit;

    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

class FinishTimeComparator implements Comparator<Job>{
    @Override
    public int compare(Job arg0, Job arg1) {
        if(arg0.end <= arg1.end){
            return -1;
        }else{
            return 1;
        }
    }

}