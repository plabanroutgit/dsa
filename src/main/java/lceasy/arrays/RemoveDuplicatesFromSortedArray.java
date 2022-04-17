package lceasy.arrays;

public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {

		int i = 0, j = i + 1, k = 1;

		while (j < nums.length) {

			if (nums[i] == nums[j]) {
				j++;
			} else {
				i++;
				k++;
				nums[i] = nums[j];
			}
		}

		return k;
	}

	public static void main(String[] args) {

		// int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int[] nums = { 1, 1, 2 };

		System.out.println(removeDuplicates(nums));
	}
}
