package _20220511;

import java.util.Arrays;

public class MinimizeMaxmPairSumArray {

	public int minPairSum(int[] nums) {

		Arrays.sort(nums);

		int max = 0;
		for (int i = 0, j = nums.length - 1; i < (nums.length + 1) / 2; i++, j--) {
			max = Math.max(max, nums[i] + nums[j]);

		}

		return max;
	}

	public static void main(String[] args) {

	}
}
