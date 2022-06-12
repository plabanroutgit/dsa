package _20220519;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinimumTimeDifference {

	public int findMinDifference(List<String> timePoints) {
		int n = timePoints.size();
		int[] times = new int[n];
		for (int i = 0; i < n; i++) {
			times[i] = parse(timePoints.get(i));
		}

		Arrays.sort(times);

		int min = times[0] - times[n - 1] + 24 * 60;
		for (int i = 1; i < n; i++) {
			min = Math.min(min, times[i] - times[i - 1]);
		}
		return min;
	}

	int parse(String s) {
		String[] split = s.split(":");
		int h = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		return h * 60 + m;
	}

	public static void main(String[] args) {

		List<String> timePoints = new LinkedList<String>();
		timePoints.add("23:59");
		timePoints.add("00:00");

		MinimumTimeDifference mtd = new MinimumTimeDifference();
		System.out.println(mtd.findMinDifference(timePoints));
	}
}
