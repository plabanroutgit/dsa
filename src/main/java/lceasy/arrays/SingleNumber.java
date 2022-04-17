package lceasy.arrays;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

	public static int singleNumber(int[] nums) {
		int sumOfSet = 0, sumOfNums = 0;
		Set<Integer> set = new HashSet<Integer>();

		for (int num : nums) {
			if (!set.contains(num)) {
				set.add(num);
				sumOfSet += num;
			}
			sumOfNums += num;
		}
		return 2 * sumOfSet - sumOfNums;
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 4, 5, 5, 2, 1 };

		System.out.println(singleNumber(nums));

	}
}
