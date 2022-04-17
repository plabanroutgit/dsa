package lcmedium.dynamicprogramming;

public class JumpGame {

	public static boolean canJump(int[] nums) {
		if (nums.length <= 1)
			return true;

		int max = nums[0]; // max stands for the largest index that can be reached.

		for (int i = 0; i < nums.length; i++) {
			// if not enough to go to next
			if (max <= i && nums[i] == 0)
				return false;

			// update max
			if (i + nums[i] > max) {
				max = i + nums[i];
			}

			// max is enough to reach the end
			if (max >= nums.length - 1)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };

		System.out.println(canJump(nums));
	}

}
