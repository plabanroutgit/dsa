package capitalone._20220722;

import java.util.Arrays;

public class _3sumClosest {

	public int threeSumClosest(int[] nums, int target) {
		int diff = Integer.MAX_VALUE;
		int sz = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < sz && diff != 0; ++i) {
			int lo = i + 1;
			int hi = sz - 1;
			while (lo < hi) {
				int sum = nums[i] + nums[lo] + nums[hi];
				if (Math.abs(target - sum) < Math.abs(diff)) {
					diff = target - sum;
				}
				if (sum < target) {
					++lo;
				} else {
					--hi;
				}
			}
		}
		return target - diff;
	}

	public static void main(String[] args) {

		// int[] nums = { -1, 2, 1, -4 };
		int[] nums = { -5, -5, -4, 0, 0, 3, 3, 4, 5 };
		int target = -2;

		_3sumClosest sc = new _3sumClosest();
		System.out.println(sc.threeSumClosest(nums, target));

	}

}
