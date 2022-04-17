package lceasy.arrays;

public class SingleNumber2 {

	public static int singleNumber(int[] nums) {
		int a = 0;
		for (int i : nums) {
			a ^= i;
		}
		return a;
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 4, 5, 5, 2, 1 };

		System.out.println(singleNumber(nums));

	}
}
