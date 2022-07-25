package capitalone._20220717;

import java.util.Arrays;

public class TwoSumLessThanK1099 {

	public int twoSumLessThanK(int[] nums, int k) {

		Arrays.sort(nums);
		int sum = 0, res = -1;
		int start = 0, end = nums.length - 1;

		while (start < end) {

			sum = nums[start] + nums[end];
			if (sum < k) {
				res = Math.max(res, sum);
				start++;
			} else {
				end--;
			}

		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 34, 23, 1, 24, 75, 33, 54, 8 };
		int k = 60;

		TwoSumLessThanK1099 ts = new TwoSumLessThanK1099();

		System.out.println(ts.twoSumLessThanK(nums, k));

	}

}
