package alimiralgos;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		int n = nums.length;

		for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
			// generate bitmask, from 0..00 to 1..11
			String bitmask = Integer.toBinaryString(i).substring(1);
			// String bitmask = Integer.toBinaryString(i);

			// append subset corresponding to that bitmask
			List<Integer> curr = new ArrayList<Integer>();
			for (int j = 0; j < n; ++j) {
				if (bitmask.charAt(j) == '1')
					curr.add(nums[j]);
			}
			output.add(curr);
		}
		return output;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };

		System.out.println(subsets(nums));
	}
}