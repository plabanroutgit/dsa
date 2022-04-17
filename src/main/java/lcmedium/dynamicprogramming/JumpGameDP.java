package lcmedium.dynamicprogramming;

enum Index {
	GOOD, BAD, UNKNOWN
}

public class JumpGameDP {
	Index[] memo;

	public boolean canJumpFromPosition(int position, int[] nums) {
		if (memo[position] != Index.UNKNOWN) {
			return memo[position] == Index.GOOD ? true : false;
		}

		int furthestJump = Math.min(position + nums[position], nums.length - 1);
		for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
			if (canJumpFromPosition(nextPosition, nums)) {
				memo[position] = Index.GOOD;
				return true;
			}
		}

		memo[position] = Index.BAD;
		return false;
	}

	public boolean canJump(int[] nums) {
		memo = new Index[nums.length];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = Index.UNKNOWN;
		}
		memo[memo.length - 1] = Index.GOOD;
		return canJumpFromPosition(0, nums);
	}

	public static void main(String[] args) {

		int[] nums = { 2, 3, 1, 1, 4 };

		JumpGameDP jg = new JumpGameDP();

		System.out.println(jg.canJump(nums));

	}
}