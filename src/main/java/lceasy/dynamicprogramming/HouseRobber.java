package lceasy.dynamicprogramming;

public class HouseRobber {

	public static int rob(int[] nums) {

		int N = nums.length;

		// Special handling for empty array case.
		if (N == 0) {
			return 0;
		}

		int robNext, robNextPlusOne;

		// Base case initializations.
		robNextPlusOne = 0;
		robNext = nums[N - 1];

		// DP table calculations. Note: we are not using any
		// table here for storing values. Just using two
		// variables will suffice.
		for (int i = N - 2; i >= 0; --i) {

			// Same as the recursive solution.
			int current = Math.max(robNext, robNextPlusOne + nums[i]);

			// Update the variables
			robNextPlusOne = robNext;
			robNext = current;
		}

		return robNext;
	}

	public static void main(String[] args) {

		int[] nums = { 2, 7, 9, 3, 1 };

		System.out.println(rob(nums));

	}

}