package lcmedium.dynamicprogramming;

public class JumpGameBackTracking {
	public boolean canJumpFromPosition(int position, int[] nums) {
		if (position == nums.length - 1) {
			return true;
		}

		int furthestJump = Math.min(position + nums[position], nums.length - 1);
		for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
			if (canJumpFromPosition(nextPosition, nums)) {
				return true;
			}
		}

		return false;
	}

	public boolean canJump(int[] nums) {
		return canJumpFromPosition(0, nums);
	}

	public static void main(String[] args) {

		int[] nums = { 2, 3, 1, 1, 4 };

		JumpGameBackTracking jg = new JumpGameBackTracking();

		System.out.println(jg.canJump(nums));

	}
}