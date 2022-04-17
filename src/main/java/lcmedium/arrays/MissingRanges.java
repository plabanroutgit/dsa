package lcmedium.arrays;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {

		List<String> result = new ArrayList<>();
		int start = lower;

		///Any where if the number in array going out Integer Max
		if (lower == Integer.MAX_VALUE) {
			return result;
		}

		for (int i = 0; i < nums.length; i++) {
			// handle duplicates, e.g., [1,1,1] lower=1 upper=1
			if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
				continue;
			}

			if (nums[i] == start) {
				start++;
			} else {
				result.add(getRange(start, nums[i] - 1));
				///Any where if the number in array going out Integer Max
				if (nums[i] == Integer.MAX_VALUE) {
					return result;
				}
				start = nums[i] + 1;
			}
		}

		if (start <= upper) {
			result.add(getRange(start, upper));
		}

		return result;
	}

	private static String getRange(int n1, int n2) {
		return n1 == n2 ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 3, 50, 75 };
		int lower = 0, upper = 99;

		List<String> rs = findMissingRanges(nums, lower, upper);

		for (int i = 0; i < rs.size(); i++) {
			System.out.println(rs.get(i));
		}

	}
}
