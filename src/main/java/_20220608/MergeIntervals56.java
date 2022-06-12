package _20220608;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals56 {

	public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

	public static void main(String[] args) {

		// int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		// int[][] intervals = { { 1, 4 }, { 4, 5 } };
		// int[][] intervals = { { 1, 4 }, { 0, 4 } };
		int[][] intervals = { { 1, 4 }, { 0, 0 } };

		MergeIntervals56 mi = new MergeIntervals56();

		for (int[] is : mi.merge(intervals)) {
			System.out.println(Arrays.toString(is));
		}

	}

}
